import scala.annotation.tailrec

object cwiki {
  def main(args: Array[String]): Unit = {
    println(lrepeat(3, LazyList('a','b','c')).force)
    println(lfib.take(15).force)
  }
//                  LISTA 1
//ZAD1
def flatten1[A](xss: List[List[A]]): List[A] = xss match {
  case Nil => Nil
  case xs :: rest => xs ::: flatten1(rest)
}

//ZAD2
def count[A](x: A, xs: List[A]): Int = xs match {
  case Nil => 0
  case hd :: tl if hd == x => 1 + count(x, tl)
  case _ :: tl => count(x, tl)
}
/*let rec count (x, xs) =
  match xs with
  | [] -> 0
  | hd :: tl when hd = x -> 1 + count (x, tl)
  | _ :: tl -> count (x, tl)*/

//ZAD3
  def replicate[A](obj: A, n: Int): List[A] = {
    if (n <= 0) {
      Nil  // Jeśli n <= 0, zwracamy pustą listę
    } else {
      obj :: replicate(obj, n - 1) // Dodajemy element x do wynikowej listy i rekurencyjnie wywołujemy funkcję dla n-1
    }

    /* OCAML
      * let rec replicate: 'a * int -> 'a list = fun(x,n) ->
        if n <= 0 then []
        else x::replicate(x, n-1);;
        * */
  }
//ZAD4
  def sqrList(xs: List[Int]): List[Int] = {
    xs.map(x => x * x) // Wykorzystujemy funkcję map do podniesienia każdego elementu do kwadratu
    /* let rec sqrList lst =
        match lst with
        | [] -> []
        | hd :: tl ->
          (hd * hd) :: sqrList tl
      ;;*/
  }
//ZAD5
  def palindrome[A] (xs: List[A]): Boolean = {
    xs == xs.reverse
  }

  //ZAD6
  def listLength[A](xs: List[A]): Int = {
    if (xs == List()) 0
    else listLength(xs.tail) + 1
  }
  /*let rec list_length xs =
    match xs with
    | [] -> 0
    | _ :: tail -> 1 + list_length tail
    ;;
*/

  //                    LISTA 2


//zad2
  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  def fibTail(n: Int): Int = {
    @annotation.tailrec
    def fib_helper(n: Int, a: Int, b: Int): Int = {
      if (n == 0) a
      else if (n == 1) b
      else fib_helper(n - 1, b, a + b)
    }

    fib_helper(n, 0, 1)
  }
  /*let rec fib n =
    if n = 0 then 0
    else if n = 1 then 1
    else fib (n - 1) + fib (n - 2)

  let fibTail n =
    let rec fib_helper n a b =
      if n = 0 then a
      else if n = 1 then b
      else fib_helper (n - 1) b (a + b)
    in
    fib_helper n 0 1*/

  //ZAD3
  def root3(a: Double): Double = {
    @annotation.tailrec
    def root3Helper(x0: Double, epsilon: Double): Double = {
      val xi = x0 - (x0 * x0 * x0 - a) / (3.0 * x0 * x0)
      if (Math.abs(xi * xi * xi - a) <= epsilon * Math.abs(a)) xi
      else root3Helper(xi, epsilon)
    }

    if (a > 1.0) root3Helper(a / 3.0, 1e-15)
    else root3Helper(a, 1e-15)
  }
  /*let root3 a =
    let rec root3_helper x0 epsilon =
      let xi = x0 -. (x0 *. x0 *. x0 -. a) /. (3.0 *. x0 *. x0) in
      if abs_float (xi ** 3.0 -. a) <= epsilon *. abs_float a then
        xi
      else
        root3_helper xi epsilon
    in

    if a > 1.0 then
      root3_helper (a /. 3.0) (1e-15)
    else
      root3_helper a (1e-15)*/
  def lrepeat[A](k: Int, lxs: LazyList[A]): LazyList[A] = {
    def repeatElem(elem: A, count: Int): LazyList[A] = {
      if (count == 0) LazyList.empty
      else elem #:: repeatElem(elem, count - 1)
    }
    lxs.flatMap(elem => repeatElem(elem, k))
  }

  def lfib: LazyList[Int] = {
    def generate(a: Int, b: Int): LazyList[Int] = a #:: generate(b, a + b)
    generate(0, 1)
  }
}
//ZAD 4
/*
* # let (_,_,x,_,_) = (-2,-1,0,1,2);;
* # let [(_,_);(x,_)] = [ (1,2); (0,1) ];;*/

//ZAD5
@tailrec
def initSegment[A](xs: List[A], ys: List[A]): Boolean = {
  if (xs == Nil) true
  else if (ys == Nil) false
  else if (xs.head != ys.head) false
  else initSegment(xs.tail, ys.tail)
}


