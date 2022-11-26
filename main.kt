val trick = {
  println("No Treats!")
}

val treat: () -> Unit = {
  println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
  if(isTrick){
    return trick
  } else {
    if(extraTreat != null){
    println(extraTreat(5))  
    }
    
    return treat
  }
}

fun main(){
  //val trickFunction = trick

  //trickFunction()
  //treat()

  val coins: (Int) -> String = {
    quantity -> "$quantity quarters"
  }  
  val cupcake: (Int) -> String = {
    "Have a cupcake!"
  }
  val treatFunction = trickOrTreat(false, coins)  
  val trickFunction = trickOrTreat(true, cupcake)
  
  treatFunction()  
  trickFunction()
  
  // $it default 
  val coins2: (Int) -> String = {
    "$it quarters"
  }
  
  val treatFunction2 = trickOrTreat(false, coins2)
  val trickFunction2 = trickOrTreat(true, null)
  treatFunction2()
  trickFunction2()

  val treatFunction3 = trickOrTreat(false){
    "$it quarters"
  }
  treatFunction3()

  //repeat function
  repeat(4){
    treatFunction3()
  }
  
}
