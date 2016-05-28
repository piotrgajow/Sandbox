( defn readInt [ prompt ]
    ( println prompt )
    ( Integer/parseInt ( read-line ) )
)

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

( defn lotto [ cumulation ] 
    ( let [ prize6 ( winnings ( chances 6 6 49 ) cumulation )
            prize5 ( winnings ( chances 5 6 49 ) 5300 )
            prize4 ( winnings ( chances 4 6 49 ) 170 )
            prize3 ( winnings ( chances 3 6 49 ) 24 )
        ] 
        ( double ( total 3 prize6 prize5 prize4 prize3 ) )
    )
)

( defn lottoZPlusem [ cumulation ] 
    ( let [ prize6 ( winnings ( chances 6 6 49 ) cumulation )
            prize5 ( winnings ( chances 5 6 49 ) 5300 )
            prize4 ( winnings ( chances 4 6 49 ) 170 )
            prize3 ( winnings ( chances 3 6 49 ) 24 )
            prize6P ( winnings ( chances 6 6 49 ) 1000000 )
            prize5P ( winnings ( chances 5 6 49 ) 3500 )
            prize4P ( winnings ( chances 4 6 49 ) 100 )
            prize3P ( winnings ( chances 3 6 49 ) 10 )
        ] 
        ( double ( total 4 prize6 prize5 prize4 prize3 prize6P prize5P prize4P prize3P ) )
    )
)

( defn ekstraPensja [] 
    ( let [ rnk1 ( winnings ( / ( chances 5 5 35 ) 4 ) 1200000 )
            rnk2 ( winnings ( chances 5 5 35 ) 25000 )
            rnk3 ( winnings ( / ( chances 4 5 35 ) 4 ) 1000 )
            rnk4 ( winnings ( chances 4 5 35 ) 200 )
            rnk5 ( winnings ( / ( chances 3 5 35 ) 4 ) 80 )
            rnk6 ( winnings ( chances 3 5 35 ) 25 )
            rnk7 ( winnings ( / ( chances 2 5 35 ) 4 ) 10 )
            rnk8 ( winnings ( chances 2 5 35 ) 5 )
        ]
        ( double ( total 4 rnk1 rnk2 rnk3 rnk4 rnk5 rnk6 rnk7 rnk8 ) )
    )
)

( do 
    ( let [ lottoCumulation ( readInt "Enter Lotto cumulation:" ) 
            ; miniLottoPrize ( readInt "Enter MiniLotto prize:" )
        ]
        ( println "" )
        ( println "Lotto:" ( lotto lottoCumulation ) )
        ( println "Lotto z plusem:" ( lottoZPlusem lottoCumulation ) )
        ( println "Ekstra pensja:" ( ekstraPensja ) )
    )
)
