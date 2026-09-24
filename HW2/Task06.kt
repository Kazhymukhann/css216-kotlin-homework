package hw2.task06

fun main() {
    val phone = FoldablePhone()
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.unfold()
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.fold()
    phone.checkPhoneScreenLight()
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val state = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $state.")
    }
}

class FoldablePhone : Phone() {
    var isFolded: Boolean = true
        private set

    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        }
    }

    fun fold() {
        isFolded = true
        switchOff()
    }

    fun unfold() {
        isFolded = false
    }
}
