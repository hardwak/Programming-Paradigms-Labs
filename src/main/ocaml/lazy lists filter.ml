let llistsFilter llists min =
  List.fold_left (fun acc llist ->
      let list = Lazy.force llist in
      if List.length list >= min then acc @ [llist]
      else acc) [] llists;;

let llists = [lazy [1; 3; 4]; lazy [2; 3]; lazy [5; 6;7;8]];;
let result = llistsFilter llists 3;; 