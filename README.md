# Java-Basic
Công nghệ JAVA được sử dụng để phát triển ứng dụng cho một môi trường rộng lớn, từ thiết bị người dùng cho tới các hệ thống phức tạp của doanh nghiệp. Trong phần này ta sẽ tìm hiểu về Java Platform và các thành phần của nó.

## Ngôn Ngữ Lập Trình JAVA
Giống như mọi ngôn ngữ lập trình, Java cũng có cấu trúc riêng và các quy định về cú pháp, là một ngôn ngữ hướng đối tượng nên nó có các tính năng của Lập trình hướng đối tượng (Tính trừu tượng, đa hình, đóng gói, kế thừa).

Java Compiler
------------------
Khi lập trình cho nền tảng Java, ta viết source code trong file .java. Khi biên dịch, Compiler sẽ kiểm tra lại syntax rồi viết ra *bytecode* trong file .class sau đó được đưa vào *Máy ảo Java* (JVM) và thông dịch thành mã máy tương ứng với hệ điều hành. Vì vậy mà chương trình viết bằng Java có thể chạy được trên nhiều hệ điều hành với điều kiện có JVM

## Java Virtual Machine
Tất cả các chương trình khi muốn thực thi được thì phải bắt buộc phải được biên dịch ra code máy. Nhờ có JVM mà Java có thể chạy trên nhiều Platform khác nhau. JVM giống như một cái máy ảo, muốn khởi chạy Java thì bắt buộc phải chạy trên cái máy ảo này.

## Cơ Chế Làm Việc
- Tìm kiếm và load các file .class vào vùng nhớ của Java
- Vùng nhớ cấp phát cho Java Virtual Machine
- Chuyển các lệnh của JVM trong file .class thành các lệnh của máy, hệ điều hành tương ứng và thực thi chúng.

### Ví dụ về quá trình compile 1 file .java
- Ta có file HelloWorld.java có mã nguồn như sau:

```
package vn.com.vng;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
} 
```
### Phân tích cú pháp chương trình HelloWorld:
> Ở dòng đầu tiên`package vn.com.vn` có chức năng chỉ dẩn nơi chứa Class HelloWorld
> Phương thức `public static void main` dùng để run chương trình.
> `System.out.println("Hello World!")`Dùng để xuất ra chuỗi được truyền vào ra Terminal

- Ta sẽ sử dụng command line để hiểu rõ quá trình compile
- Đầu tiên ta phải thay đổi directory cùng với file .java: (do class Main nằm trong package vn.com.vng nên file HelloWorld.java sẽ có đường dẫn là .vn/com/vng)
- Sau đó dùng lệnh: `javac HelloWorld.java` để compile thành bytecode
- Sau khi compile trong cùng thư mục sẽ xuất hiện file `HelloWorld.class`
- Để chuyển bytecode thành mã máy và thực thi ta dùng lênh: `java vn.com.vng.HelloWorld`

Kết Quả: Không tìm thấy file HelloWorld.class
```
~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ java vn.com.vng.HelloWorld
 Error: Could not find or load main class Main
```
Vì sao?
- Vì Classloader trong JVM có chức năng tìm kiếm file .class nó dựa vào package của file .java nên nó vào classpath là `vn/com/vng` mà ta lại thực hiện câu lệnh hiện tại ở: `.vn/com/vng` nên Classloader sẽ không tìm thấy file `HelloWorld.class`.

Giải quyết:
- Thay đổi đường dẫn thực hiện câu lệnh cho phù hợp với package. Trong trường hợp này: `cd ../../..` sau đó dùng lệnh như bình thường
- Hoặc cung cấp pathclass cho Classloader biết đường dẫn của file .class `java -cp ../../.. vn.com.vng.HelloWorld `

Kết Qủa:
```
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ java -cp ../../../  vn.com.vng.Main
Hello World!
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ cd ../../..
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src$ java vn.com.vng.Main
Hello World!
```

Class
--------------
Class giống là 1 blueprint của entity(object) gồm có thuộc tính và hành động, class sẽ định nghĩa cấu trúc của object
Một Class trong Java có thể chứa: 
> Ví dụ: Con người có các thuộc tính:  tên, tuổii, giới tính, chiều cao, cân nặng,... và có các hành động ăn, ngủ, chạy,...
> Ta tạo class như sau

`````
public class Person{
    private String ten;
    private int tuoi;
    private float chieuCao;
    private float canNang;

    pubic void an(){
        System.out.println("Eatting");
    }

    public void ngu(){
        
    }

    public void chay(){

    }
    
}
`````

> Ở đây ta tạo 1 class Person có các thuộc tính  và có các "hành động" eat, sleep, walk

Object
--------------
Object là một thực thể 







Variables
---------------
1 biến gồm:
+ AcceessSpecifier gồm (private, deafault, protected, public)
+ Kiểu dữ liệu (...)
+ Tên biến

Các loại biến trong java:
- *Biến local*: là các biến khai báo trong constructor, method, khối và không cần accessmodifer khi khai báo và cần khởi tạo giá trị mặc định
- *Biến instance*: là attribute khai báo trong class, có accessmodifier được tạo ra khi đối tượng được tạo bằng từ khóa `new`
- *Biến static*: là biến có từ khóa static, biến static được tạo mà không cần khởi tạo đối tượng, được truy cập thông qua class 

Các kiểu dữ liệu nguyên thủy
-----------------------
| Kiểu dữ liệu        | Kích thước    | Gía trị mặc định  |      Giới hạn giá trị       |
| -------------       |:-------------:|:------------------:|---------------------------:|
| boolean             | 1 byte        |    false            |     true or false              |          
| byte                | 1 byte      |       0                |   -128 to 127            |
| char                | 2 byte      |        unsigned        | \u0000' \u0000' to \uffff' or 0 to 65535      |
|short                |2 byte       |      0                |    -32768 to 32767       |
|int                  |4 byte       |      0                |  -2147483648 to 2147483647     |
|long                 |8 byte       |       0              |  -9223372036854775808 to 9223372036854775807   |
|float                |4 byte       |       0.0                 |   1.17549435e-38 to 3.4028235e+38    |
|double               |8 byte       |        0.0              |    4.9e-324 to 1.7976931348623157e+308   |

Method
--------
1 phương thức gồm có:
* Accessmodifier
* Tên Phương thức
* Tham Số
* Kiểu dữ liệu trả về (trừ void)
* Phương thức có thể được gọi bởi object hoặc class(phương thức static)

Cách đặt tên method khuyến nghị: 
* Bắt đầu với 1 ký tự thường 
* Tránh dùng số trừ khi thật sự cần thiết
* Chỉ sử dụng ký tự alphabetaric

Constructor
---------------
Constructor trong java là một dạng đặc biệt của phương thức được sử dụng để khởi tạo các đối tượng, Java Constructor được gọi tại thời điểm tạo đối tượng. Nó khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng

### Đặc Điểm của Constructor:
- Tên Contructor là tên của Class
- Contructor không có kiểu giá trị trả về
- Có 2 loại Constructor là: Mặc định và có tham số
- Nếu không có Contructor thì Java sẽ tạo ra constructor mặc định.


Getter
--------------
- Dùng để lấy giá trị của thuộc tính (thường thuộc tính dùng Accessmodifier là private)
```
public class Person{
    private String name;
    private int age;
}
```

Setter
-------------
- Dùng để thay đổi giá trị của thuộc tính 


Hướng Đối Tượng Trong JAVA
======================

Tính trừu tượng (Abstraction)
- Tính trừu tượng để các lớp sử dụng các phương thức và thuộc tính của nó mà không cần quan tâm đến nội dung trong đó.
```
abstract public class Hinh {
    public static int soLuongHinh;

    Hinh(){
        this.soLuongHinh++;
    }

    public abstract float chuVi();
    public abstract float dienTich();
}

public class HinhChuNhat extends Hinh{
    private int chieuDai;
    private int chieuRong;

    HinhChuNhat(){

    }

    HinhChuNhat(int cd,int cr){
        this.chieuDai=cd;
        this.chieuRong=cr;
    }

    public float chuVi(){
        return (chieuDai+chieuRong)*2;
    }

    public float dienTich(){
        return chieuDai*chieuRong;
    }
}
```

```
public class Main {
    public static void main(String[] args) {
        Hinh h=new HinhChuNhat(5,2);
        Hinh h2=new HinhChuNhat();

        System.out.println("Chu vi: "+h.chuVi());
        System.out.println("Dien tich: "+h.dienTich());
        System.out.println("So Luong Hinh: "+Hinh.soLuongHinh);
    }
}
```

Output:
```
Chu vi: 14.0
Dien tich: 10.0
So Luong Hinh: 2
```
Tính kế thừa (Inheritance)
- Tính kế thừa giúp các lớp con có thể tái sử dụng lại các thuộc tính và phương thức của lớp cha

```
class Hinh{
    float chuVi()
    float dienTich()
}
```

### Overidde
