package com.codemobiles.myauthen


//fun main() {
//    // implicit
//    var a1 = 1234
//    var a2 = "1234"
//    var a3 = 14.5
//    var a4 = true
//
//    // explicit
//    var b1: Int = 1234
//    var b2: String = "1234"
//    var b3: Float = 14.5F // f or F, default: double
//    var b4: Boolean = true
//
//    // implicit vs explicit
////    var c1 = 5555
////    var c2: Int = codemobiles()
//
//    a1 = 5555
//    b1 = 7777
//    a2 = "tanakorn"
//    b2 = "yai"
//
//
//    val c1 = 1234
//    val c2: Int = 1234
//
//    //c1 = 5555
//
//    print("a1: $a1, a2: ${a2.length}")
//}


//fun main() {
//    normalFN()
//    argsFN(1234, "1234")
//    val result: Int = returnFN(1234)
//}
//
//fun normalFN(){
//    // todo
//}
//
//fun argsFN(x1: Int, x2: String){
//    // todo
//}
//
//fun returnFN(x1: Int): Int{
//    return x1
//}


fun main() {

    // any
    val array1 = arrayOf(1234, "1234", true, 1.46)
    var array2 = arrayOf<Int>(1234, 555, 666, 6666)

    array1[0] = 5555


    val array3 = listOf(123, "12412", true, 1.56)
    val array4 = listOf<Int>(123, 444, 5555, 756)

   // array3[0] = 5555

    val list1 = ArrayList<Int>()
    list1.add(5555)
    list1.add(5555)
    list1.remove(5555)
}