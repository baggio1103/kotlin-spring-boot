package com.example.demo.repository

import com.example.demo.data.Comment
import com.example.demo.data.Post
import com.example.demo.data.User
import com.example.demo.tables.Comments.COMMENTS
import com.example.demo.tables.Posts.POSTS
import org.jooq.DSLContext
import org.jooq.impl.DSL.*
import org.springframework.stereotype.Repository

@Repository
class PostRepository(
    private val dslContext: DSLContext
) {


    fun getPostById(id: Long): Post {
        return dslContext.select(
            POSTS.ID,
            POSTS.TITLE,
            POSTS.CONTENT,
            row(POSTS.users().ID, POSTS.users().NAME, POSTS.users().EMAIL)
                .mapping { userId, name, email -> User(userId, name, email) }
                .`as`("createdBy")
        ).from(POSTS)
            .where(POSTS.ID.eq(id))
            .fetchOptional { Post(it.value1(), it.value2(), it.value3(), it.value4()) }
            .orElseThrow { throw IllegalArgumentException() }
    }

    fun getUserPosts(id: Long): List<Post> {
        return dslContext.select(
            POSTS.ID,
            POSTS.TITLE,
            POSTS.CONTENT,
            row(POSTS.users().ID, POSTS.users().NAME, POSTS.users().EMAIL)
                .mapping { userId, name, email -> User(userId, name, email) }
        ).from(POSTS)
            .where(POSTS.CREATED_BY.eq(id))
            .fetch { Post(it.value1(), it.value2(), it.value3(), it.value4()) }
    }

    fun getPostByIdWithComments(id: Long): Post {
        return dslContext.select(
            POSTS.ID,
            POSTS.TITLE,
            POSTS.CONTENT,
            row(POSTS.users().ID, POSTS.users().NAME, POSTS.users().EMAIL)
                .mapping { userId, name, email -> User(userId, name, email) }
                .`as`("createdBy"),
            multiset(
                select(COMMENTS.ID, COMMENTS.NAME, COMMENTS.CONTENT, COMMENTS.CREATED_AT, COMMENTS.UPDATED_AT).from(
                    COMMENTS
                ).where(POSTS.ID.eq(COMMENTS.POST_ID))
            ).`as`("comments").convertFrom { row ->
                row.map {
                         Comment(it.value1(), it.value2(), it.value3(), it.value4(), it.value5())
                }
            },
            POSTS.CREATED_AT,
            POSTS.UPDATED_AT
        ).from(POSTS)
            .where(POSTS.ID.eq(id))
            .fetchOptional {
                Post(it.value1(), it.value2(), it.value3(), it.value4(), it.value5(), it.value6(), it.value7())
            }
            .orElseThrow { throw IllegalArgumentException() }
    }

}