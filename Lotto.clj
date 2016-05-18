
(defn testLottery []
    (println "Test Lottery")
)

(defn menu []
    (do 
        (println "0. Exit")
        (println "1. Test")
        (let [in (read-line)] 
            (case in
                "0" (System/exit 0)
                "1" (testLottery)
                (menu)
            )
        )
    )
)

(menu)

