fun main(args:Array<String>){
    /*val theWolf:Animal = Wolf()
    theWolf.makeNoise()
    theWolf.roam()
    theWolf.sleep()*/
    val vet = Vet()
    val animals:Array<Animal> = arrayOf(
        Hippo(),
        Lion(),
        Cheetah(),
        Lynx(),
        Fox()
    )
    for (animal in animals){
        println()
        println("*******************")
        println(animal.image)
        println(animal.habitat)
        animal.roam()
        animal.eat()
        vet.giveShot(animal)

    }

    val roamables:Array<Roamable> = arrayOf(
            Hippo(),
            Lion(),
            Cheetah(),
            Lynx(),
            Fox(),
            Car()
    )
    for (roamable in roamables){
        println("*******************")
            roamable.roam()
            if(roamable is Animal){
                roamable.eat()
            }
    }
}

interface Roamable{
    var velocity: Int
    get() = 20
    set(value) {
        print(value)
        println("km/s Unable to update velocity")
    }
    fun roam()
}

open class Car() :Roamable{
    override fun roam() {
        println("The Vehicle is roaming")
    }
}
/*
class ConvertibleCar(make_param:String,model_param:String):Car(make_param,model_param){

}*/

abstract class Animal:Roamable{
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()

    abstract fun eat()

    override fun roam(){
        println("The animal is roaming")
    }

    fun sleep(){
        println("The animal is sleeping")
    }
}

class Hippo:Animal(){
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise(){
        println("Grunt! Grunt!")
    }

    override fun eat(){
        println("The Hippo is eating $food")
    }

}

abstract class Canine:Animal(){

    override fun roam(){
        println("The canine is roaming")
    }
}

class Wolf:Canine(){
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise(){
        println("Hooooowl!")
    }

    override fun eat(){
        println("The wolf is eating $food")
    }
}

class Fox:Canine(){
    override val image = "Fox.jpg"
    override val food = "meat"
    override val habitat = "steeps"

    override fun makeNoise(){
        println("Bark!")
    }

    override fun eat(){
        println("The fox is eating $food")
    }
}

abstract class Feline:Animal(){

    override fun roam(){
        println("The feline is roaming")
    }
}

class Lion:Feline(){
    override val image = "lion.jpg"
    override val food = "meat"
    override val habitat = "savannah"

    override fun makeNoise(){
        println("Roar!")
    }

    override fun eat(){
        println("The lion is eating $food")
    }
}

class Cheetah:Feline(){
    override val image = "cheetah.jpg"
    override val food = "meat"
    override val habitat = "grassland"

    override fun makeNoise(){
        println("Meow!")
    }

    override fun eat(){
        println("The cheetah is eating $food")
    }
}

class Lynx:Feline(){
    override val image = "lynx.jpg"
    override val food = "meat"
    override val habitat = "mountain"

    override fun makeNoise(){
        println("skr!")
    }

    override fun eat(){
        println("The lynx is eating $food")
    }
}

class Vet{
    fun giveShot(animal: Animal){
        animal.makeNoise()
    }
}