class ListWithTrash<T>(
    private val delegate: MutableList<T> = ArrayList()
) : MutableList<T> by delegate {
    var lastDeleted: T? = null
        private set

    override fun remove(element: T) = delegate.remove(element).also { isSuccessful ->
        if (isSuccessful) lastDeleted = element
    }

    override fun removeAt(index: Int) = delegate.removeAt(index).also {
        lastDeleted = it
    }
}