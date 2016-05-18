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

( defn winnings [ prob prize ] 
    ( * prob prize )
)

( defn lotto [] 
    ( println "Lotto" )
    ( println "Cumulation?" )
    ( let [ cumulation ( Integer/parseInt ( read-line ) ) 
            prize6 ( winnings ( chances 6 6 49 ) cumulation )
            prize5 ( winnings ( chances 5 6 49 ) 5300 )
            prize4 ( winnings ( chances 4 6 49 ) 170 )
            prize3 ( winnings ( chances 3 6 49 ) 24 )
        ] 
        ( println "Result" ( double ( total 3 prize6 prize5 prize4 prize3 ) ) )
    )
)

( defn ekstraPensja [] 
    ( println "Ekstra pensja" )
    ( let [ rnk1 ( winnings ( / ( chances 5 5 35 ) 4 ) 1200000 )
            rnk2 ( winnings ( chances 5 5 35 ) 25000 )
            rnk3 ( winnings ( / ( chances 4 5 35 ) 4 ) 1000 )
            rnk4 ( winnings ( chances 4 5 35 ) 200 )
            rnk5 ( winnings ( / ( chances 3 5 35 ) 4 ) 80 )
            rnk6 ( winnings ( chances 3 5 35 ) 25 )
            rnk7 ( winnings ( / ( chances 2 5 35 ) 4 ) 10 )
            rnk8 ( winnings ( chances 2 5 35 ) 5 )
        ]
        ( println "Result" ( double ( total 5 rnk1 rnk2 rnk3 rnk4 rnk5 rnk6 rnk7 rnk8 ) ) )
    )
)

( defn menu []
    ( do 
        ( println "" )
        ( println "0. Exit" )
        ( println "1. Lotto" )
        ( println "2. Ekstra pensja")
        ( println "Choice?" )
        ( let [ in ( read-line ) ] 
            ( case in
                "0" ( System/exit 0 )
                "1" ( lotto )
                "2" ( ekstraPensja )
                ()
            )
            ( menu )
        )
    )
)

( menu )