package com.company;
        _container.add(_gameButton);
        _container.add(_alphabetButton);
        _container.add(_scoreLabel);
        _container.add(_errorLabel);
        _container.add(_timeLabel);
        _container.add(_emptyLabel);


        InitializeButtons();
        ActionButton();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void GenerateLevel(){
        try{
            OpenFile();

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    public void OpenFile()  throws FileNotFoundException {
        int i=0;
        String temp1,temp2;
        FileReader rf = new FileReader("src/com/company/file.txt");
        Scanner scan = new Scanner(rf);
        String str="";
        str = scan.nextLine();
        //for (int i = 0; i < 32; i++) {
        while(scan.hasNextLine() && i<32){
            temp1="";
            temp2="";
           int _temp = SubStringOnParts(str);
            temp1 = str.substring(0, _temp);
            _buttons[i].setText(temp1);
            temp2 = str.substring(_temp + 1);
            _buttons[i+32].setText(temp2);

            str = scan.nextLine();
            //System.out.println(scan.hasNextLine());
            i++;

        }
        //rf.close();
    }

    int SubStringOnParts(String str){
        //String temp="";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                return i;
                //System.out.println("fuck");
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main app = new Main(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

    }

}
