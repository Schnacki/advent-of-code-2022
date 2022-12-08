import Day7.Command.*
import Day7.Node.*

object Day7 : Day {

    sealed interface Command {
        object UP : Command
        object DOWN : Command
        data class FileEntry(val size: Int) : Command
    }

    sealed interface Node {
        val size: Int

        data class DirNode(val children: MutableList<Node>, val parent: DirNode?) : Node {
            fun listDirectories(): List<DirNode> =
                this.children.filterIsInstance<DirNode>().flatMap(DirNode::listDirectories) + this

            override val size: Int
                get() = children.sumOf(Node::size)
        }

        data class FileNode(override val size: Int) : Node
    }

    private fun parseCommands(input: List<String>) = input.mapNotNull {
        when {
            it == "$ cd .." -> UP
            it.startsWith("$ cd") -> DOWN
            it.first().isDigit() -> FileEntry(it.takeWhile(Char::isDigit).toInt())
            else -> null
        }
    }

    private fun buildFileSystem(input: List<String>): DirNode {
        var current = DirNode(mutableListOf(), null)
        val root = current
        parseCommands(input).forEach { command ->
            when (command) {
                is DOWN -> DirNode(mutableListOf(), current).apply {
                    current.children.add(this)
                    current = this
                }

                is UP -> current.parent?.apply { current = this }
                is FileEntry -> current.children.add(FileNode(command.size))
            }
        }
        return root
    }

    override fun part1(input: List<String>): Int =
        buildFileSystem(input).listDirectories()
            .filter { it.size < 100000 }
            .sumOf { it.size }

    override fun part2(input: List<String>): Int {
        val root = buildFileSystem(input)
        val neededSpace = 30000000 - (70000000 - root.size)
        return root.listDirectories()
            .filter { it.size > neededSpace }
            .minBy { it.size }.size
    }
}