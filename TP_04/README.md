# Tugas Pemrograman 4

## Evaluator untuk Ekspresi Postfix dengan Menggunakan ADT Stack

### Deskripsi Tugas

Rancang dan implementasikan sebuah Java application, dengan JavaFX-based GUI, yang menghitung nilai
ekspresi dalam notasi postfix (notasi Polish) yang menggunakan operand integer dengan operator-operator
arithmetic sbb:
\+ (addition),
− (subtraction),
\* (multiplication),
/ (division), dan
$ (exponentiation).

Program menerima input berupa ekspresi infix, lalu mentransformasi ekspresi infix itu menjadi ekspresi postfix,
kemudian menghitung nilainya. Keuntungan notasi postfix akan dipelajari di bawah.

Contoh-contoh interaksi:


We usually use infix expressions, in which an operator is positioned between its two operands. A postfix
expression puts the operators after its operands. Keep in mind that an operand could be the result
of another operation. Postfix notation eliminates the need for parentheses to force precedence.
For example, the following infix expression:
(5 + 2) * (8 − 5)
is equivalent to the following postfix expression:
5 2 + 8 5 − *
The evaluation of a postfix expression is facilitated by using a stack. As you process a postfix expression from left
to right, you encounter operands and operators. If you encounter an operand, push it on the stack. If you encounter
an operator, pop two operands off the stack, perform the operation, and push the result back on the stack. When
you have processed the entire expression, there will be one value on the stack, which is the result of the entire
expression. You can use a StringTokenizer object to assist in the parsing of the expression.


Pergunakan algoritma untuk konversi dari ekspresi infix ke ekspresi postfix.