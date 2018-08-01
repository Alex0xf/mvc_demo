package com.javasm.game.vo;

import com.javasm.game.model.BookModel;
import com.javasm.game.model.GameModel;

public class PlayVO {
	private BookModel book;
	private GameModel game;
	
	public BookModel getBook() {
		return book;
	}
	public void setBook(BookModel book) {
		this.book = book;
	}
	public GameModel getGame() {
		return game;
	}
	public void setGame(GameModel game) {
		this.game = game;
	}
	
	
}
