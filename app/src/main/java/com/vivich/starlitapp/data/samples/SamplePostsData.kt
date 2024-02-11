package com.vivich.starlitapp.data.samples
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.vivich.starlitapp.model.post.Markup
import com.vivich.starlitapp.model.post.MarkupType
import com.vivich.starlitapp.model.post.Paragraph
import com.vivich.starlitapp.model.post.ParagraphType
import com.vivich.starlitapp.model.post.Post
import com.vivich.starlitapp.model.post.PostAuthor
import com.vivich.starlitapp.model.post.PostsFeed
import com.vivich.starlitapp.model.post.Metadata
import com.vivich.starlitapp.model.post.Publication

val jammy = PostAuthor(
    name="Jammy",
    title="Unemployed",
    url = ""
)

val plato = PostAuthor(
    name="Plato",
    title="Philosopher",
    url=""
)

val diogenes = PostAuthor(
    name="Plato",
    title="Homeless",
    url=""
)

val publication = Publication(
    "Vivich Dev",
    "Hexagon"
)

val loremIpsumParagraphs = listOf(
    Paragraph(
        type = ParagraphType.Text,
        text=LoremIpsum(20).toString()
    )
)

val highlightPosts = Post(
    id = "hilight1a2s",
    title = "Highlight post",
    url = "",
    publication = publication,
    metadata = Metadata(
        author = jammy,
        date = "",
        readTimeMinutes = 2
    ),
    paragraphs = loremIpsumParagraphs
)

val jammyParagraphs = listOf(
    Paragraph(
        type = ParagraphType.Text,
        text = "Jammy is Jammy"
    ),
    Paragraph(
        type = ParagraphType.Text,
        text= "Jammy is not a student"
    )
)
val jammyPost = Post(
    id="jammy102119",
    title="",
    url="",
    publication = publication,
    metadata = Metadata(
        author = jammy,
        date = "Today",
        readTimeMinutes = 1
    ),
    paragraphs = jammyParagraphs
)

val recommendParagraphs = listOf(
    Paragraph(
        ParagraphType.Text,
        "Jammy is looking for a full-time position"
    ),
    Paragraph(
        ParagraphType.Text,
        "Hire Jammy"
    )
)

val recentParagraphs = listOf(
    Paragraph(
        ParagraphType.Text,
        "Google has recently removed Kotlin Basics"
    ),
    Paragraph(
        ParagraphType.Text,
        "So Compose is the way to go"
    )
)

val popularParagraphs = listOf(
    Paragraph(
        ParagraphType.Text,
        "Django something something",
        listOf(
            Markup(MarkupType.Bold, 0, 5)
        )
    ),
    Paragraph(
        ParagraphType.Text,
        "Flask something something",
        listOf(
            Markup(MarkupType.Bold, 0, 4)
        )
    )
)

val posts : PostsFeed =
    PostsFeed(
        highlightedPost = highlightPosts,
        recommendedPosts = listOf(highlightPosts),
        recentPosts = listOf(highlightPosts),
        popularPosts = listOf(highlightPosts),
    )