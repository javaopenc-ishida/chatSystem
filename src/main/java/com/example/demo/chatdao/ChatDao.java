package com.example.demo.chatdao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntChat;


@Repository
public class ChatDao {
	private final JdbcTemplate db;
	
	public ChatDao(JdbcTemplate db) {
		this.db = db;
	}
//名前とコメントを追加する	
	public void insertDb(EntChat entchat) {
		db.update("INSERT INTO chat (name,comment) VALUES(?,?)", entchat.getName(),entchat.getComment());
	}

	public List<EntChat> searchDb() {
		String sql = "SELECT * FROM data";
		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		//画面に表示しやすい形のList(resultDB2)を用意
		List<EntChat> resultDb2 = new ArrayList<EntChat>();
		//1件ずつピックアップ
		for (Map<String, Object> result1 : resultDb1) {
			//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
			EntChat entformdb = new EntChat();
			//id、nameのデータをentformdbに移す
			entformdb.setId((int) result1.get("id"));
			entformdb.setName((String) result1.get("name"));
			//移し替えたデータを持ったentformdbを、resultDB2に入れる
			resultDb2.add(entformdb);
		}
		//Controllerに渡す
		return resultDb2;
	}
}
