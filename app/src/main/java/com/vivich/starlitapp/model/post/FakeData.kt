package com.vivich.starlitapp.model.post

data class FakeCard(
    val imageUrl: String,
    val title: String,
    val author: String,
    val content: String,
)

val bigFakeCardData = listOf(
    FakeCard(
        imageUrl = "https://cdn.britannica.com/84/87984-050-7C5547FE/Detail-Roman-copy-portrait-bust-Aristotle-Greek.jpg",
        title = "Aristotle Nicomachean ethics",
        author = "Aristotle",
        content = "We may now return to the Good which is the object of our search, and try to find out what exactly it can be. For good appears to be one thing in one pursuit or art and another in another: it is different in medicine from what it is in strategy, and so on with the rest of the arts. What definition of the Good then will hold true in all the arts? Perhaps we may define it as that for the sake of which everything else is done. This applies to something different in each different art—to health in the case of medicine, to victory in that of strategy, to a house in architecture, and to something else in each of the other arts; but in every pursuit or undertaking it describes the end of that pursuit or undertaking, since in all of them it is for the sake of the end that everything else is done.",
    ),
    FakeCard(
        imageUrl = "https://classicalwisdom.com/wp-content/uploads/2013/01/socrates-statue.jpg",
        title = "Sokrates's Crito",
        author = "Sokrates",
        content = "Are we to say that we are never intentionally to do wrong, or that in one way we ought and in another way we ought not to do wrong, or is doing wrong always evil and dishonorable, as I was just now saying, and as has been already acknowledged by us?\n" +
                "Are all our former admissions which were made within a few days to be thrown away? And have we, at our age, been earnestly discoursing with one another all our life long only to discover that we are no better than children? Or are we to rest assured, in spite of the opinion of the many, and in spite of consequences whether better or worse, of the truth of what was then said, that injustice is always an evil and dishonor to him who acts unjustly? Shall we affirm that?"
    ),
    FakeCard(
        imageUrl = "https://cdn.britannica.com/88/149188-050-DC34842F/Plato-portrait-bust-original-Capitoline-Museums-Rome.jpg",
        title = "Plato's Apology",
        author = "Plato",
        content = "There you are mistaken: a man who is good for anything ought not to calculate the chance of living or dying; he ought only to consider whether in doing anything he is doing right or wrong - acting the part of a good man or of a bad.\n" +
                "Whereas, according to your view, the heroes who fell at Troy were not good for much, and the son of Thetis above all, who altogether despised danger in comparison with disgrace; and when his goddess mother said to him, in his eagerness to slay Hector, that if he avenged his companion Patroclus, and slew Hector, he would die himself - \"Fate,\" as she said, \"waits upon you next after Hector\"; he, hearing this, utterly despised danger and death, and instead of fearing them, feared rather to live in dishonor, and not to avenge his friend."
    )
)

val mediumFakeCardData = listOf(
    FakeCard(
        imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiiwxoKujOGZO2PxfhLIMX18dE9OANNbFzJsngYvgGgTNjgrjAriCYby-HB6e9Xzvvnf86ZV54VUyXDoC8pj8-vnNN-TaAjwv5EHA-5K6uw5yTPgK5mTEJi_gDVyoSJsssOosYBn8RUcl0/s1600/Life+of+Brian+1.jpg",
        title = "Romanes eunt domus?",
        author = "",
        content = "People called Romanes they go to the house?"
    ),
    FakeCard(
        imageUrl = "https://cdn.britannica.com/88/149188-050-DC34842F/Plato-portrait-bust-original-Capitoline-Museums-Rome.jpg",
        title = "“Man is a featherless biped.”",
        author = "Plato",
        content = ""
    ),
    FakeCard(
        imageUrl = "https://images3.memedroid.com/images/UPLOADED40/5f803bfd06118.jpeg",
        title = "“Behold, I bring you Plato’s man!”",
        author = "Diogenes",
        content = ""
    ),
)