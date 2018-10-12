package br.edu.ifpe.jpa.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.querydsl.core.types.Predicate;

import br.edu.ifpe.jpa.example.entities.Blog;
import br.edu.ifpe.jpa.example.entities.QBlog;
import br.edu.ifpe.jpa.example.entities.QPost;
import br.edu.ifpe.jpa.querydsl.EntityManagerHelper;

public class App {

	static EntityManagerHelper helper = EntityManagerHelper.getInstance();

	public static void main(String[] args) {
	}


	// 1. Imprima na tela todos os blogs que possuem o id maior que 10
	public void questaoUm() {
		QBlog blog = QBlog.blog;

		helper.execute((query) -> {
			List<Blog> blogsId =
					query
					.select(blog)
					.from(blog)
					.where(blog.identifier.gt(10))
					.fetch();

			System.out.println(blogsId);

		});
	}

	// 2. Imprima na tela a descrição do blog que possui o nome "dia a dia, bit a bit"
	public void questaoDois() {
		QBlog blog = QBlog.blog;

		helper.execute((query) -> {
			List<String> blogDescription = 
					query
					.select(blog.description)
					.from(blog)
					.where(blog.description.eq("dia a dia, bit a bit"))
					.fetch();

			System.out.println(blogDescription);

		});
	}

	// 3. Imprima na tela as decrições dos 5 primeiros blogs criados (considerar o atributo creationDate)
	public void questaoTres() {
		QBlog blog = QBlog.blog;

		helper.execute((query) -> {
			List<String> firstBlogs =
					query
					.select(blog.description)
					.from(blog)
					.where((Predicate) blog.creationDate.asc())
					.limit(5)
					.fetch();

			System.out.println(firstBlogs);

		});
	}

	// 4. Imprima na tela o título e conteúdo de todos os posts do blog com título recebido como parâmetro, 
	//ordenados alfabeticamente pelo título do post
	public void questaoQuatro(String titulo) {
		QPost post = QPost.post;

		helper.execute((query) -> {
			List<String> postBlog =
					query
					.select(post.title)
					.from(post)
					.where(post.title.contains(titulo))
					.orderBy(post.title.asc())
					.fetch();

			System.out.println(postBlog);

		});
	}

	// 5. Imprima na tela o título do último post do blog com título "título"
	public void questaoCinco(String titulo) {
		QPost post = QPost.post;

		helper.execute((query) -> {
			List<String> postDoBlog =
					query
					.select(post.title)
					.from(post)
					.where(post.title.contains(titulo))
					.orderBy(post.title.asc())
					.limit(1)
					.fetch();

			System.out.println(postDoBlog);
		});

	}

	// 6. Retorne uma lista com os títulos de todos os posts publicados no blog com título tituloBlog 
	//entre o período dataInicial e dataFinal.
	public List<String> questaoSeis(Date dataInicial, Date dataFinal, String tituloBlog) {
		QPost post = QPost.post;
		QBlog blog = QBlog.blog;

		List<String> list = new ArrayList<>() ;
		helper.execute((query) -> {
			list.addAll(
					query
					.select(blog, post)
					.from(blog, post)
					.where(blog.name.eq(tituloBlog).and(blog.creationDate.between(dataInicial, dataFinal)))
					.where(post.title.eq(tituloBlog))
					.fetch());
		});

		return list;

	}

	// 7. Imprima na tela a média de posts existentes nos blogs
	public void questaoSete() {

	}
}
