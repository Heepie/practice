class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flatMap()
        map()
        guGuDan()
        getSales()
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
    
    // filter, reduce 함수 사용
    fun getSales() {
        // 결과가 없을 수도 있기 때문에 Maybe 객체 사용
        var tvSales:Maybe<Int> =
            Observable.just("TV: $2,500", "Camera: $300", "TV: $1,600", "Phone: $800")
                      .filter { item -> item.startsWith("TV:") }
                      .map { tv -> tv.split("$")[1].replace(",","").toInt() }
                      .reduce { value1: Int, value2: Int ->  value1 + value2}

        tvSales.subscribe { result -> Log.e("heepie", "$result") }
    }
}
