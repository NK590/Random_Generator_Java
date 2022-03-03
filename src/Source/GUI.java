package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI extends JFrame {
    Dimension frameDim = new Dimension(400, 400);
    DefaultListModel<String> inputMembers = new DefaultListModel<>();
    String tempInput;
    Random random = new Random();

    public GUI() {
        // 프레임 설정
        this.setTitle("Random Generator");
        this.setSize(frameDim);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // 텍스트필드 설정
        JTextField inputText = new JTextField();

        inputText.setBounds(30, 30, 200, 30);
        inputText.setHorizontalAlignment(JTextField.RIGHT);

        this.getContentPane().add(inputText);

        // 버튼 설정
        JButton inputButton = new JButton("입력");
        JButton selectClearButton = new JButton("선택 삭제");
        JButton allClearButton = new JButton("전부 삭제");
        JButton exitButton = new JButton("종료");
        JButton runButton = new JButton("랜덤 뽑기");

        inputButton.setBounds(250, 30, 100, 30);
        selectClearButton.setBounds(250, 80, 100, 30);
        allClearButton.setBounds(250, 130, 100, 30);
        exitButton.setBounds(250, 180, 100, 30);
        runButton.setBounds(250, 230, 100, 30);

        this.getContentPane().add(inputButton);
        this.getContentPane().add(selectClearButton);
        this.getContentPane().add(allClearButton);
        this.getContentPane().add(exitButton);
        this.getContentPane().add(runButton);

        // 리스트 설정
        JList memberList = new JList<>(inputMembers);
        memberList.setBounds(30, 80, 200, 180);
        this.getContentPane().add(memberList);

        // 텍스트 에리어 설정
        JTextArea outputText = new JTextArea("결과 : ");
        outputText.setBounds(30, 280, 320, 30);
        this.getContentPane().add(outputText);

        // 버튼 액션 설정
        inputButton.addActionListener(event -> {
            tempInput = inputText.getText();
            if (!tempInput.equals("")) {
                inputMembers.addElement(tempInput);
                inputText.setText("");
            }
        });
        selectClearButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                DefaultListModel selectedItems = (DefaultListModel) memberList.getModel();
                int selectedIndex = memberList.getSelectedIndex();
                if (selectedIndex != -1) selectedItems.remove(selectedIndex);
            }
        });
        allClearButton.addActionListener(event -> {
            inputMembers.removeAllElements();
            outputText.setText("결과 : ");
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        runButton.addActionListener(event -> {
            int sizeInputMembers = inputMembers.size();
            if (sizeInputMembers != 0) {
                int randomIndex = random.nextInt(sizeInputMembers);
                outputText.setText("결과 : " + inputMembers.elementAt(randomIndex));
            }
        });

        // 프레임 가시화
        this.setVisible(true);
    }
}
