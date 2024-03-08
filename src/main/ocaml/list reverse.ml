let revlst lst =
  List.fold_right(fun x acc -> acc @ [x]) lst [];;
revlst [2;3;4;5];;