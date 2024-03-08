type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let rec revTree tree = 
  match tree with
  | Empty -> Empty
  | Node(n, left, right) -> Node(n, revTree right, revTree left);;

let t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty);;
revTree t;;
(*revTree t ;;
- : int bt = Node (1, Empty, Node (2, Node (3, Empty, Empty), Empty))*)