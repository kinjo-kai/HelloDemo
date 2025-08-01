package cs;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Introduction {

	public static void main(String[] args) {
		// フレーム作成
		JFrame frame= new JFrame("ポートフォリオ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setLayout(new BorderLayout());
		
		//画像
		ImageIcon icon= new ImageIcon("profile.jpg"); //ファイル名も変更
		Image scaledImage=icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon=new ImageIcon(scaledImage);
		JLabel Label=new JLabel(resizedIcon);
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		//自己紹介
		JLabel introLabel=new JLabel("こんにちは、Java開発者の金城です。",SwingConstants.CENTER);
		
		//スキル一覧
		String skills="<html><ul>"+
					"<li>Java</li>"+
					"</ul></html>";
		JLabel skillsLabel=new JLabel(skills,SwingConstants.CENTER);
		
		//GitHubボタン
		JButton githubButton = new JButton("GitHubを見る");
		githubButton.addActionListener((ActionEvent e)->{
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/yourusername"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		//パネルの準備
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(Label);
		panel.add(introLabel);
		panel.add(skillsLabel);
		panel.add(githubButton);
		
		//余白を追加
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		//フレームに追加して表示
		frame.add(panel,BorderLayout.CENTER);
		frame.setVisible(true);

	}

}
