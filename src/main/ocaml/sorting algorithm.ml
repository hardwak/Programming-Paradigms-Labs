let distance (x, y) = x * x + y * y;;

let rec insert elem points = match points with
  | [] -> [elem]  (*1 element jset posortowany*)
  | hd::tl -> if distance elem <= distance hd then elem::points else hd :: insert elem tl;; (*wstawia element jezeli jest mniejszy od poczatku listy, jezeli nie
                                                                                          to szuka miejsca do wstawienia w reszcie listy, <= zachowuje stabilnosc*) 
                                                                                          
let rec sort points = match points with
  | [] -> []  (* pusta lista posortowana *)
  | hd::tl -> insert hd (sort tl);;(* wstawia 1 element do listy posortowanej, rekurencyjnie rozdziela liste na pojedyncze elementy 
                                 i od konca zbiera je w posortowana liste*) 

let points = [(1,2); (5,2); (2,1); (1,1); (2,5); (0,0)];;
let sorted_points = sort points;;