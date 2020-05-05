class Test {
    fun test(): Boolean {
        for (i in 2 downTo 1){
            System.out.println(i)
        }

        var hello:NullClass? = NullClass(null)


        System.out.println(hello?.str?.length)

        return true
    }
}

class NullClass(var str:String?)