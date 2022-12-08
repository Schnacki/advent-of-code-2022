object Day07 : Day {

    sealed interface Command
    object UP : Command
    object DOWN : Command
    data class FileEntry(val size: Int) : Command

    sealed interface Node {
        val size: Int
    }

    data class DirNode(val children: MutableList<Node> = mutableListOf(), val parent: DirNode? = null) : Node {
        fun listDirectories(): List<DirNode> =
            this.children.filterIsInstance<DirNode>().flatMap(DirNode::listDirectories) + this

        override val size: Int
            get() = children.sumOf(Node::size)
    }

    data class FileNode(override val size: Int) : Node

    private fun parseCommands(input: List<String>) = input.mapNotNull {
        when {
            it == "$ cd .." -> UP
            it.startsWith("$ cd") -> DOWN
            it.first().isDigit() -> FileEntry(it.takeWhile(Char::isDigit).toInt())
            else -> null
        }
    }

    private fun buildFileSystem(input: List<String>): DirNode {
        var current = DirNode()
        val root = current
        parseCommands(input).forEach { command ->
            when (command) {
                is DOWN -> DirNode(parent = current).apply {
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

    override fun part2(input: List<String>): Int =
        buildFileSystem(input).let { rootDir ->
            val neededSpace = 30_000_000 - (70_000_000 - rootDir.size)
            rootDir.listDirectories()
                .filter { it.size > neededSpace }
                .minBy { it.size }.size
        }
}
