package yogiyo;

public class File {

    public static void main(String[] args) {
        String S = "root r-x delete-this.xls\n"
            + "root r-- bug-report.pdf\n"
            + "root r-- doc.xls\n"
            + "root r-- podcast.flac\n"
            + "alice r-- system.xls\n"
            + "root --x invoices.pdf\n"
            + "admin rwx SETUP.PY";
        solution(S);
    }

    public static void solution(String S){

        String[] A = S.split("\n");
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++){
            if (A[i].substring(0,4).contains("root")){
//                if ("doc,xls,pdf".indexOf(A[i]) > 0){
//                    String[] B = A[i].split(" ");
//                    if (B[1].contains("r") & !B[1].contains("w")){
//                        min = Math.min(min, B[3].length());
//                    }
//                }
                if (A[i].substring(A[i].length()-3).contains("doc")
                || A[i].substring(A[i].length()-3).contains("xls")
                || A[i].substring(A[i].length()-3).contains("pdf")){
                    String[] B = A[i].split(" ");
                    if (B[1].contains("r") & !B[1].contains("w")){
                        min = Math.min(min, B[2].length());
                    }
                }
            }
        }
        if (Integer.MAX_VALUE == min){
            System.out.println("NO FILES");
        }else {
            System.out.println(min);
        }
    }
}
