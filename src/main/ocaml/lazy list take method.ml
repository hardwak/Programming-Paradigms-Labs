type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;(*z wykladu*) 

let rec lfrom k = LCons (k, function () -> lfrom (k+1));;(*z wykladu*)

let rec ltakeHelper n lst acc =
  match (n, lst) with
  | (0, _) -> acc
  | (_, LNil) -> acc
  | (n, LCons(x, xf)) -> ltakeHelper (n-1)  (xf()) (acc @ [x]);;

let ltake (n, lst) = ltakeHelper n lst [];;
ltake (18, lfrom (-10));; 
(*- : int list =
[-10; -9; -8; -7; -6; -5; -4; -3; -2; -1; 0; 1; 2; 3; 4; 5; 6; 7]*)