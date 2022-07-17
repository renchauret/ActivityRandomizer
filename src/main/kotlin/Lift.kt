import kotlin.math.min
class Lift: Activity {
    val type: String
    val lifts: List<Activity>

    constructor(
        name: String,
        morningStrength: Int,
        eveningStrength: Int = morningStrength,
        liftMap: Map<Activity, Array<Activity>>,
        maxLifts: Int
    ) : super(name, morningStrength, eveningStrength) {
        val workout = defineWorkout(liftMap, maxLifts)
        type = workout.first.name
        lifts = workout.second
    }

    fun defineWorkout(
        liftMap: Map<Activity, Array<Activity>>,
        maxLifts: Int
    ): Pair<Activity, List<Activity>> {
        val type = getActivity(liftMap.keys)
        val potentialLifts = mutableListOf(*liftMap[type]!!)
        val finalMaxLifts = min(maxLifts, potentialLifts.size)
        val numLifts = (1..finalMaxLifts).random()

        val lifts: MutableList<Activity> = mutableListOf()
        for (i in 1..numLifts) {
            val newLift = getActivity(potentialLifts)
            lifts.add(newLift)
            potentialLifts.remove(newLift)
        }

        return Pair(type, lifts)
    }

    override fun toString(): String {
        return super.toString() + ": " + type + "\n" + lifts.map { l -> "$l" }
    }
}