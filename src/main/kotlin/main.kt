fun main(args: Array<String>) {
    val liftMap = mapOf(
        Activity("Push", 3) to arrayOf(
            Activity("Heavy Bench", 3),
            Activity("Light Bench", 1),
            Activity("Incline Bench", 1),
            Activity("Shoulder Press", 1),
            Activity("Side Raises", 2),
            Activity("Front Raises", 1),
            Activity("Triceps Extensions", 2)
        ),
        Activity("Pull", 2) to arrayOf(
            Activity("Bent-over Row", 2),
            Activity("Upright Row", 1),
            Activity("Deadlift", 3),
            Activity("Barbell Curls", 2),
            Activity("Dumbbell Curls", 1),
            Activity("Pull Ups", 1),
            Activity("Chin Ups", 1)
        ),
        Activity("Legs", 3) to arrayOf(
            Activity("Heavy Squat", 3),
            Activity("Light Squat", 1),
            Activity("Hamstring Extensions", 1)
        ),
        Activity("Arms", 2) to arrayOf(
            Activity("Barbell Curls", 3),
            Activity("Dumbbell Curls", 1),
            Activity("Triceps Extensions", 3),
            Activity("Wrist Curls", 1),
            Activity("Close-grip Bench", 1)
        )
    )

    val activities = mutableListOf(
        Activity("Read", 1, 3),
        Lift("Lift", 3, 4, liftMap, 5),
        Activity("Yoga", 1, 1),
        Activity("Walk", 4, 1),
        Activity("Relax", 1, 2)
    )

    while(true) {
        println("m for morning, e for evening, x to exit")
        val input = readLine()
        if (input == "x") {
            break
        } else if (input == "m") {
            val activity = getActivity(activities, false)
            println(activity.toString())
        } else if (input == "e") {
            val activity = getActivity(activities, true)
            println(activity.toString())
        }
        activities[1] = Lift("Lift", 3, 4, liftMap, 5)
    }
}

fun getActivity(
    activities: Iterable<Activity>,
    useEvening: Boolean = false
): Activity {
    val max = activities.sumBy { a -> a.getStrength(useEvening) }
    val num = (1..max).random()
    var activity = activities.first()
    var sum = 0
    activities.forEach { a ->
        activity = a
        sum += a.getStrength(useEvening)
        if (sum >= num) return activity
    }
    return activity
}
