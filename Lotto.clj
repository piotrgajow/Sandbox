( defn total [ price & winnings ] 
    ( - ( reduce + winnings ) price )
)

( defn factorial [ x ]
    ( reduce *' ( range 1 ( inc x ) ) )
)

( defn combinations [ x y ]
    ( / ( factorial y ) ( * ( factorial x ) ( factorial ( - y x ) ) ) )
)

( defn chances [ hit winning total ]
    ( let [ hitComb ( combinations hit winning )
            missComb ( combinations ( - winning hit ) ( - total winning ) )
            totalComb ( combinations winning total )
        ] 
        ( / ( * hitComb missComb ) totalComb )
    )
)

( defn chancesPrized [ hit winning total prize ] 
    ( * ( chances hit winning total ) prize )
)

( defn lotto [] 
    ( println "Lotto" )
    ( println "Cumulation?" )
    ( let [ cumulation ( Integer/parseInt ( read-line ) ) 
            prize6 ( chancesPrized 6 6 49 cumulation )
            prize5 ( chancesPrized 5 6 49 5300 )
            prize4 ( chancesPrized 4 6 49 170 )
            prize3 ( chancesPrized 3 6 49 24 )
        ] 
        ( println "Result" ( double ( total 3 prize6 prize5 prize4 prize3 ) ) )
    )
)

( defn menu []
    ( do 
        ( println "" )
        ( println "0. Exit" )
        ( println "1. Lotto" )
        ( println "Choice?" )
        ( let [ in ( read-line ) ] 
            ( case in
                "0" ( System/exit 0 )
                "1" ( lotto )
                ()
            )
            ( menu )
        )
    )
)

( menu )