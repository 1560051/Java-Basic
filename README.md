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

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
} 
```

- Ta sẽ sử dụng command line để hiểu rõ quá trình compile
- Đầu tiên ta phải thay đổi directory cùng với file .java: (do class Main nằm trong package vn.com.vng nên file HelloWorld.java sẽ có đường dẫn là .vn/com/vng)
- Sau đó dùng lệnh: `javac HelloWorld.java` để compile thành bytecode
- Sau khi compile trong cùng thư mục sẽ xuất hiện file `HelloWorld.class`
- Để chuyển bytecode thành mã máy và thực thi ta dùng lênh: `java vn.com.vng.HelloWorld`

Kết Quả:
```
 Error: Could not find or load main class Main
```
Vì sao?
- Vì Classloader trong JVM có chức năng tìm kiếm file .class nó dựa vào package của file .java nên nó vào classpath là `vn/com/vng` mà ta lại thực hiện câu lệnh hiện tại ở: `.vn/com/vng` nên Classloader sẽ không tìm thấy file `HelloWorld.class`.

Giải quyết:
- Thay đổi đường dẫn thực hiện câu lệnh cho phù hợp với package. Trong trường hợp này: `cd ../../..` sau đó dùng lệnh như bình thường
- Hoặc cung cấp pathclass cho Classloader biết đường dẫn của file .class `java -cp ../../.. vn.com.vng.Main `

Kết Qủa:
```
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ java -cp ../../../  vn.com.vng.Main
Hello World!
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ cd ../../..
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src$ java vn.com.vng.Main
Hello World!
```
Variables
---------------
| Kiểu dữ liệu        | Kích thước    | Gía trị mặc định  |      Giới hạn giá trị       |
| -------------       |:-------------:|             :-----:|---------------------------:|
| boolean             | 1 byte          |            false |     true or false              |          
| byte                | 1 byte     |               0 |          -128 to 127            |
| char                | 2 byte     |                unsiged |       \u0000' \u0000' to \uffff' or 0 to 65535      |
|short              |2 byte         |                0   |           -32768 to 32767       |
|int                |4 byte|                          0  |         -2147483648 to 2147483647     |
|long               |8 byte|                           0    |        -9223372036854775808 to 9223372036854775807   |
|float              |4 byte|                           0.0     |        1.17549435e-38 to 3.4028235e+38    |
|double             |8 byte|                         0.0       |         4.9e-324 to 1.7976931348623157e+308   |



OOP
---------------