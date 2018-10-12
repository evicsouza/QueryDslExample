package br.edu.ifpe.jpa.example.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlog is a Querydsl query type for Blog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBlog extends EntityPathBase<Blog> {

    private static final long serialVersionUID = -2051897614L;

    public static final QBlog blog = new QBlog("blog");

    public final DatePath<java.util.Date> creationDate = createDate("creationDate", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> identifier = createNumber("identifier", Integer.class);

    public final StringPath name = createString("name");

    public final CollectionPath<Post, QPost> posts = this.<Post, QPost>createCollection("posts", Post.class, QPost.class, PathInits.DIRECT2);

    public QBlog(String variable) {
        super(Blog.class, forVariable(variable));
    }

    public QBlog(Path<? extends Blog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlog(PathMetadata metadata) {
        super(Blog.class, metadata);
    }

}

