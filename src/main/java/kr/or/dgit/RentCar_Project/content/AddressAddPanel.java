package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.RentCar_Project.dto.Post;
import kr.or.dgit.RentCar_Project.service.PostService;

@SuppressWarnings("serial")
public class AddressAddPanel extends JPanel {
	private PostService postService = PostService.getInstance();
	private String address;
	private List<Post> lists;

	public List<Post> getLists() {
		return lists;
	}

	public String getAddress() {
		return address;
	}

	public AddressAddPanel(Post post, JTextField tf, AddressFrame af) {
		lists = postService.selectPostByDoro(post);

		for (int i = 0; i < lists.size(); i++) {
			AddressContent addrContent = new AddressContent(lists.get(i).toString());
			add(addrContent);
			addrContent.getBtnSelect().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					address = addrContent.getLblNewLabel().getText();
					tf.setText(address);
					af.setVisible(false);
				}
			});
		}
	}

}
