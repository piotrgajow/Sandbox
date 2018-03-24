module Hello exposing (..)

import Html exposing (Html, div, text, hr, input, p, h3, label, button)
import Html.Attributes exposing (for, id, type_)
import Html.Events exposing (onInput, onClick)

main =
    Html.beginnerProgram { model = model, view = view, update = update }

-- MODEL

type alias Model =
    { lottoPrizePool : Int
    , lottoTicket : Int
    , lottoPrize : Float
    , jackpotPrizePool : Int
    , jackpotTicket : Float
    , jackpotPrize : Float
    }

model : Model
model =
    { lottoPrizePool = 0
    , lottoTicket = 3
    , lottoPrize = 0
    , jackpotPrizePool = 0
    , jackpotTicket = 12.5
    , jackpotPrize = 0
    }

-- UPDATE

type Msg
    = LottoAmountChange String
    | LottoCalculate
    | JackpotAmountChange String
    | JackpotCalculate

update : Msg -> Model -> Model
update msg model =
    case msg of
        LottoAmountChange newAmount ->
            { model | lottoPrizePool = Result.withDefault 0 ( String.toInt newAmount ) }
        LottoCalculate ->
            { model | lottoPrize = calculateLottoPrize ( toFloat model.lottoPrizePool ) }
        JackpotAmountChange newAmount ->
            { model | jackpotPrizePool = Result.withDefault 0 ( String.toInt newAmount ) }
        JackpotCalculate ->
            { model | jackpotPrize = calculateJackpotPrize ( toFloat model.jackpotPrizePool ) }

calculateLottoPrize : Float -> Float
calculateLottoPrize prizePool =
    List.sum
        [ 0.44 * prizePool / 13983816
        , 5300 / 54201
        , 170 / 1032
        , 24 / 57
        ]

calculateJackpotPrize : Float -> Float
calculateJackpotPrize prizePool =
    List.sum
        [ 0.36 * prizePool / 95344200
        , 0.085 * prizePool / 5959013
        , 0.03 * prizePool / 3405150
        , 0.01 * prizePool / 423752
        , 0.009 * prizePool / 26485
        , 0.007 * prizePool / 15134
        , 0.006 * prizePool / 9631
        , 0.031 * prizePool / 672
        , 0.03 * prizePool / 602
        , 0.043 * prizePool / 344
        , 0.078 * prizePool / 128
        , 0.191 * prizePool / 42
        ]

-- VIEW

view : Model -> Html Msg
view model =
    div [] 
        [ div [] 
            [ h3 [] [ text "Lotto"]
            , p [] [ text ( String.concat [ "Ticket price: ", toString model.lottoTicket, " PLN" ] ) ]
            , label [ for "lotto-amount" ] [ text "Total winnings pool" ]
            , input [ onInput LottoAmountChange, id "lotto-amount", type_ "number" ] []
            , button [ onClick LottoCalculate ] [ text "Calculate" ]
            , p [] [ text ( String.concat [ "Prize: ", toString ( model.lottoPrize ) ] ) ]
            ]
        , div []
            [ h3 [] [ text "Euro Jackpot"]
            , p [] [ text ( String.concat [ "Ticket price: ", toString model.jackpotTicket, " PLN" ] ) ]
            , label [ for "jackpot-amount" ] [ text "Total winnings pool" ]
            , input [ onInput JackpotAmountChange, id "jackpot-amount", type_ "number" ] []
            , button [ onClick JackpotCalculate ] [ text "Calculate" ]
            , p [] [ text ( String.concat [ "Prize: ", toString ( model.jackpotPrize ) ] ) ]
            ]
        ]
