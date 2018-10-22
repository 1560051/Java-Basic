//Đề: chuyển chuổi ban đầu thành chuỗi viết tắt
//vd: First In, First Out =>FIFO


class Acronym {
    private String str;
    Acronym(String phrase) {
        this.str=new String(phrase);
    }

    String get() {
        String s2=new String();
        //tách chuỗi các câu thành chuỗi
        String[] ss=str.split(" - | |-");
        //duyệt mảng chuỗi và chỉ lấy ký tự đầu của câu đó
        for(int i=0;i<ss.length;i++){
            char c=ss[i].charAt(0);
            s2=s2+c;
        }
        return s2=s2.toUpperCase();
    }

}
