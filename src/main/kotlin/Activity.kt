open class Activity(
    val name: String,
    val morningStrength: Int,
    val eveningStrength: Int = morningStrength
) {
    fun getStrength(useEvening: Boolean = false): Int {
        return if (useEvening) eveningStrength else morningStrength
    }

    override fun toString(): String {
        return name
    }
}