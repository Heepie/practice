class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flatMap()
        map()
        guGuDan()
    }

    fun flatMap() {
        var ball = arrayOf("1","3","5")
        var source = Observable.just("1","3","5")
                .flatMap { ball -> Observable.just(ball + "^") }
                .subscribe{item -> Log.e("heepie", item)}
    }

    fun map() {
        var ball = arrayOf("1","3","5")
        var source = Observable.just("1","3","5")
                .map { ball -> ball + "^" }
                .subscribe{item -> Log.e("heepie", item)}
    }

    fun guGuDan() {
        Observable.range(1,9)
                  .flatMap { dan -> Observable.range(1,9)
                                              .map { incNum -> "$dan X $incNum = ${dan*incNum}" }}
                  .subscribe { result -> Log.e("heepie", result) }
    }
}
