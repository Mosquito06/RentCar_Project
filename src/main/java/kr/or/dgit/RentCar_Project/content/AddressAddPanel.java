package kr.or.dgit.RentCar_Project.content;

import java.util.List;

import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.dto.Post;
import kr.or.dgit.RentCar_Project.service.PostService;

@SuppressWarnings("serial")
public class AddressAddPanel extends JPanel {
	private PostService postService = PostService.getInstance();

	public AddressAddPanel(Post post) {
		
		List<Post> lists=postService.selectPostByDoro(post);
		
		for(int i=0;i<lists.size();i++) {
			AddressContent addrContent = new AddressContent(lists.get(i).toString());
			add(addrContent);
		}
	}

}
