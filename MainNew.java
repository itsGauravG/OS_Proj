import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class MainNew {
    static char M[][] = new char[100][4];     //Physical Memory
    static char IR[] = new char[4];         //Instruction Register (4 bytes)
    static char R[] = new char[4];          //General Purpose Register (4 bytes)
    static int IC;             //Instruction Counter Register (2 bytes)
    static int SI;             //Interrupt
    static boolean C;             //Toggle (1 byte)
    static char LR[] = new char[40];
    static char CR[] = new char[40];
    static int BT=0; // 0 signifies not similar
    static char buffer[] = new char[40];
    static char arr[] = new char[100];
    static int x; //GD
    static int y; //LR
    static int z; //CR
    static int a; //PD
    static int b; //BT

    static int linenum;


    public static void main(String[] args) throws IOException, InterruptedException {
        init();
        load();

    }

    static void init() {
        //initializeing main memeory with null chars (making it empty)
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < 4; j++) {
                M[i][j] = '\0';
            }
        }

        for (int i = 0; i < 4; i++) {
            IR[i] = '\0';
            R[i] = '\0';
        }

        C = false;

    }


    static void MOS() throws IOException {


        if (SI == 2)        //Write Mode
        {
            System.out.println("inside si 2");

            File f = new File("/Users/gauravgaikwad/IdeaProjects/JavaPrograms/src/output.txt"); //Creation of File Descriptor for output file
            FileWriter fw = new FileWriter(f);  //Creation of File Writer object





            for(int i=a;i<100;i++){

                for(int j=0;j<4;j++){

                    System.out.println(M[i][j]);

                }
            }



            for(int i=a;i<100;i++){

                for(int j=0;j<4;j++){

                    fw.write(M[i][j]);

                }
            }
            fw.flush();
            fw.close();




        }


        else if (SI == 1) {     // get data
            for (int i = 0; i <= 39; i++)
                buffer[i] = '\0';

            // no go where hello world is written in inout file
            // change this
            //infile.getline(buffer,40);
            System.out.println("line number to get: "+ linenum);


            String line = Files.readAllLines(Paths.get("/Users/gauravgaikwad/IdeaProjects/JavaPrograms/src/input.txt")).get(linenum);
            System.out.println(line);

            arr = line.toCharArray();
            int arr_len = arr.length;
            System.out.println("len of arr "+arr.length);
            //there is the problem of arr size that's casuing issue in the error , fixing it now

            for(int i=0;i<arr.length-1;i++){
               buffer[i] = arr[i+1];
            }

//            buffer[0] = arr[0];
//            buffer[1] = arr[1];
//            buffer[2] = arr[2];
//            buffer[3] = arr[3];

            System.out.println("arr[0]" + arr[0]);
            System.out.println("arr[1]" + arr[1]);
            System.out.println("arr[2]" + arr[2]);
            System.out.println("arr[3]" + arr[3]);

            //copy contents of arr to buffer



//            for(int k=0;k<12;k++){
//                if(arr[k]=='\n'){
//                    buffer[k]= '\0';
//                    break;
//                }
//                else {
//                    buffer[k] = arr[k+1];
//                }
//            }
            // now buffer has hello world in it

//            int k = 0;
//            int i = IR[2] - 48;
//            i = i * 10;


//            for (int l = 0; l < 10; ++l) {
//                for (int j = 0; j < 4; ++j) {
//                    M[i][j] = buffer[k];
//                    k++;
//                }
//                if (k == 40) {
//                    break;
//                }
//                i++;
//            }
            //copying it to main memory
//            for (int i =0;i<20;i++){
//                System.out.println(buffer[i]);
//            }




            //we have to store from buffer into main memory x has the address or row num




            System.out.println("buffer[0]"+buffer[0]);
            System.out.println("buffer[1]"+buffer[1]);
            System.out.println("buffer[2]"+buffer[2]);
            System.out.println("buffer[3]"+buffer[3]);

            int p=0;

                for(int i=x;i<100;i++){
                    if(p>arr_len){
                        break;
                    }

                    for(int j=0;j<4;j++){
                        if(p>arr_len){
                            break;
                        }
                        M[i][j] = buffer[p];
                        p+=1;
                    }
                }

                //now increaminting line numebr for next line VIIT
                linenum+=1;

//            int k=0;
//            for(int i=x ;i<100;i++){
//
//
//                for(int j =0;j<4;j++){
//                    if(k <40) {
//                        M[i][j] = arr[k+1];
//                        k++;
//                    }
//                }
//            }


            //whats inside rows
            System.out.println("M[12][0]: "+ M[12][0]);
            System.out.println("M[12][1] "+ M[12][1]);
            System.out.println("M[12][2] "+ M[12][2]);
            System.out.println("M[12][3] "+ M[12][3]);

            System.out.println("M[20][0]: "+ M[20][0]);
            System.out.println("M[20][1] "+ M[20][1]);
            System.out.println("M[20][2] "+ M[20][2]);
            System.out.println("M[20][3] "+ M[20][3]);

            System.out.println("M[30][0]: "+ M[30][0]);
            System.out.println("M[30][1] "+ M[30][1]);
            System.out.println("M[30][2] "+ M[30][2]);
            System.out.println("M[30][3] "+ M[30][3]);

            System.out.println("M[31][0]: "+ M[31][0]);
            System.out.println("M[31][1] "+ M[31][1]);
            System.out.println("M[31][2] "+ M[31][2]);
            System.out.println("M[31][3] "+ M[31][3]);

            System.out.println("M[50][0]: "+ M[50][0]);
            System.out.println("M[50][1] "+ M[50][1]);
            System.out.println("M[50][2] "+ M[50][2]);
            System.out.println("M[50][3] "+ M[50][3]);

            System.out.println("M[51][0]: "+ M[51][0]);
            System.out.println("M[51][1] "+ M[51][1]);
            System.out.println("M[51][2] "+ M[51][2]);
            System.out.println("M[51][3] "+ M[51][3]);




            System.out.println("prining whats inside main memory");

            for (int i = 0; i < 100; i++) {

                for (int j = 0; j < 4; j++) {
                    System.out.print(M[i][j]); // hello world

                }

            }

        }


    }

    static void execute() throws IOException {
        System.out.println("whats in the main memory ");


        System.out.println("M[0][0]: "+ M[0][0]);
        System.out.println("M[0][1] "+ M[0][1]);
        System.out.println("M[0][2] "+ M[0][2]);
        System.out.println("M[0][3] "+ M[0][3]);

        System.out.println("M[1][0]: "+ M[1][0]);
        System.out.println("M[1][1] "+ M[1][1]);
        System.out.println("M[1][2] "+ M[1][2]);
        System.out.println("M[1][3] "+ M[1][3]);

        System.out.println("M[2][0]: "+ M[2][0]);
        System.out.println("M[2][1] "+ M[2][1]);
        System.out.println("M[2][2] "+ M[2][2]);
        System.out.println("M[2][3] "+ M[2][3]);

        System.out.println("M[4][0]: "+ M[4][0]);
        System.out.println("M[4][1] "+ M[4][1]);
        System.out.println("M[4][2] "+ M[4][2]);
        System.out.println("M[4][3] "+ M[4][3]);

        System.out.println("M[8][0]: "+ M[8][0]);
        System.out.println("M[8][1] "+ M[8][1]);
        System.out.println("M[8][2] "+ M[8][2]);
        System.out.println("M[8][3] "+ M[8][3]);

        System.out.println("M[9][0]: "+ M[9][0]);
        System.out.println("M[9][1] "+ M[9][1]);
        System.out.println("M[9][2] "+ M[9][2]);
        System.out.println("M[9][3] "+ M[9][3]);

        System.out.println("M[12][0]: "+ M[12][0]);
        System.out.println("M[12][1] "+ M[12][1]);
        System.out.println("M[12][2] "+ M[12][2]);
        System.out.println("M[12][3] "+ M[12][3]);

        System.out.println("M[20][0]: "+ M[20][0]);
        System.out.println("M[20][1] "+ M[20][1]);
        System.out.println("M[20][2] "+ M[20][2]);
        System.out.println("M[20][3] "+ M[20][3]);






        try {
            while (true) {


                for (int i = 0; i < 4; i++)        //Load in register
                {
                    IR[i] = M[IC][i];

                }


                if (IR[0] == 'G' && IR[1] == 'D')    //GD
                {
                    System.out.println("IR[0]: "+ IR[0]);
                    System.out.println("IR[1]: "+ IR[1]);
                    System.out.println("IR[2]: "+ IR[2]);
                    System.out.println("IR[3]: "+ IR[3]);

                    int k1 = Character.getNumericValue(IR[2]);
                    int k2 = Character.getNumericValue(IR[3]);

                    x = k1*10 + k2;
                    System.out.println(x);


                    System.out.println("getdata");
                    SI = 1;
                    MOS();
                    IC+=1;
//                    linenum+=1;

                } else if (IR[0] == 'P' && IR[1] == 'D')       //PD
                {
                    System.out.println("\n\n");
                    System.out.println("IR[0]: "+ IR[0]);
                    System.out.println("IR[1]: "+ IR[1]);
                    System.out.println("IR[2]: "+ IR[2]);
                    System.out.println("IR[3]: "+ IR[3]);

                    int k4 = Character.getNumericValue(IR[2]);
                    int k5 = Character.getNumericValue(IR[3]);

                    a = k4*10 + k5;

                    System.out.println("put data");
                    SI = 2;
                    MOS();
                    IC+=1;
                } else if(IR[0] == 'L' && IR[1] == 'R'){

                    System.out.println("Reading LR");

                    System.out.println("\n\n");
                    System.out.println("IR[0]: "+ IR[0]);
                    System.out.println("IR[1]: "+ IR[1]);
                    System.out.println("IR[2]: "+ IR[2]);
                    System.out.println("IR[3]: "+ IR[3]);

                    int k3 = Character.getNumericValue(IR[2]);
                    int k4 = Character.getNumericValue(IR[3]);

                    y = k3*10 + k4;

                    int t = 0;

                    System.out.println("y="+y);


                    for (int i = 0;i<4;i++){
                        if(t>40){
                            break;
                        }
                        LR[t] = M[y][i];
                        t+=1;
                    }

                    System.out.println("LR[0] "+LR[0]);
                    System.out.println("LR[1] " + LR[1]);
                    System.out.println("LR[2] " + LR[2]);
                    System.out.println("LR[3] " + LR[3]);


                    IC+=1;
                }

                else if(IR[0] == 'C' && IR[1] == 'R'){

                    System.out.println("Reading CR");

                    System.out.println("\n\n");
                    System.out.println("IR[0]: "+ IR[0]);
                    System.out.println("IR[1]: "+ IR[1]);
                    System.out.println("IR[2]: "+ IR[2]);
                    System.out.println("IR[3]: "+ IR[3]);

                    int k4 = Character.getNumericValue(IR[2]);
                    int k5 = Character.getNumericValue(IR[3]);

                    z = k4*10 + k5;
                    System.out.println("z "+z);

                    //copy address content into CR from main memory to compare it with LR
                    int p=0;
                    for (int i = 0;i<4;i++){
                        if(p>40){
                            break;
                        }
                        CR[p] = M[z][i];
                        p+=1;
                    }

                    System.out.println("whats inside CR");

                    System.out.println("CR[0]: "+ CR[0]);
                    System.out.println("CR[1]: "+ CR[1]);
                    System.out.println("CR[2]: "+ CR[2]);
                    System.out.println("CR[3]: "+ CR[3]);

                    //now we have to compare contents of CR with LR char by char

                    //by default BT is 0 which means CR and LR are not same
                    //lets set BT to 1 -- same
                    // BT 0 -- not same   BT 1 -- same

                    BT =1;
                    for(int i=0;i<4;i++){
                        if(CR[i] != LR[i]){
                            BT=0;
                            break;
                        }
                    }

                    System.out.println("now BT is : "+ BT);

                    // now if BT is 0 execute the adjacent insturction
                    // if BT is 1 then skip to instruction in front of BT








                    IC+=1;
                }

                else if(IR[0] == 'B' && IR[1] == 'T'){

                    System.out.println("\n\n");
                    System.out.println("IR[0]: "+ IR[0]);
                    System.out.println("IR[1]: "+ IR[1]);
                    System.out.println("IR[2]: "+ IR[2]);
                    System.out.println("IR[3]: "+ IR[3]);




                    if(BT == 1){ //same

                        int k6 = Character.getNumericValue(IR[2]);
                        int k7 = Character.getNumericValue(IR[3]);

                        b = k6*10 + k7;
                        System.out.println("Current instruction number is "+ IC);
                        System.out.println("We have to go to "+ b);

                        int to_go = b - IC;
                        System.out.println("skip "+ to_go);

                        IC= IC+to_go;
                        System.out.println("go to IC "+ IC);
                        //skip to  inst of the address infront of BT

                    }
                    else{

                        IC+=1;

                    }



                }

                else if (IR[0] == 'H')      //Hault
                {

                    System.out.println("IR[0]: "+ IR[0]);
                    System.out.println("IR[1]: "+ IR[1]);
                    System.out.println("IR[2]: "+ IR[2]);
                    System.out.println("IR[3]: "+ IR[3]);

                    exit(0);
//            SI = 3;
//            MOS();
//            break;
                }
            }

        }catch (Exception e){
            System.out.println("");
        }
    }


    static void load() throws IOException, InterruptedException {

        System.out.println("Reading the input from file");
        //first clear the buffer


        for (int i = 0; i < 40; i++) {
            buffer[i] = ' ';
        }

        // store the first line of input file into the buffer
        File f = new File("/Users/gauravgaikwad/IdeaProjects/JavaPrograms/src/input.txt");     //Creation of File Descriptor for input file
        FileReader fr = new FileReader(f);   //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        int k = 0;

        while ((c = br.read()) != -1) {

            linenum++;

            //first empty the buffer for each new line

            for (int i = 0; i < 40; i++) {
                buffer[i] = ' ';
            }


            for (int i = 0; i < 40; i++) {
                c = br.read();
                char character = (char) c;
                //System.out.println(character);


                if (character == '\n') {
                    break; // one line is read completely
                }

                buffer[i] = character;
            }

            // what's in buffer
            for (int i = 0; i < 40; i++) {
                System.out.print(buffer[i]);
            }

            // now check the buffer


            if (buffer[0] == '$' && buffer[1] == 'A' && buffer[2] == 'M' && buffer[3] == 'J') { //new job started
                System.out.println("inside amj");
                //clear buffer
                for (int i = 0; i < 40; i++) {
                    buffer[i] = ' ';
                }


                //now read next job card


            } else if (buffer[0] == '$' && buffer[1] == 'D' && buffer[2] == 'T' && buffer[3] == 'A') {
                IC = 00;
                for (int i = 0; i < 40; i++) {
                    buffer[i] = ' ';
                }
                System.out.println("inside dta");
                //execute

                //store hello world inside buffer



                execute();


            } else {
                System.out.println("inside else");



                k = 0;

                for (int x = 0; x < 100; x++) {
                    for (int j = 0; j < 4; j++) {

                        //storing the program in main memory
                        if(buffer[k] == 'H') {

                            M[x][0] = buffer[k];
                            M[x][1] = '\0';
                            M[x][2] = '\0';
                            M[x][3] = '\0';
                            k++;
                            break;

                        }else {
                            M[x][j] = buffer[k];
                            k++;
                        }
                    }

                    if (k == 40 || buffer[k] == ' ' || buffer[k] == '\n') {
                        break;
                    }

                }

                for (int i = 0; i < 40; i++) {
                    buffer[i] = ' ';
                }

            }


        }
    }
}