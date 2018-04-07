package com.pseudo.tdd
//
//import org.scalatest.{FunSuite, Matchers}
//import shapeless._
//
//class TraitSpecs extends FunSuite with Matchers {
//
//  sealed trait HasDiscount {
//    def discount: Int
//  }
//
//  case class TV(name: String, override val discount: Int) extends HasDiscount
//
//  import copyTrait._
//
//  test("can copy instance of trait") {
//    val tv: HasDiscount = TV("Sony", 100)
//
//    tv.copy(discount = 200) shouldBe TV(name = "Sony", 200)
//
//  }
//
//  object copyTrait {
//
//    class CopyTrait[T](t: T) {
//
//      object copy extends RecordArgs {
//        def applyRecord[R <: HList](r: R)(implicit update: UpdateRepr[T, R]): T = update(t, r)
//      }
//
//    }
//
//    implicit def apply[T](t: T): CopyTrait[T] = new CopyTrait[T](t)
//  }
//
//  trait UpdateRepr[T, R <: HList] {
//    def apply(t: T, r: R): T
//  }
//
//  object UpdateRepr {
//
//    import ops.record._
//
//    implicit def mergeUpdateRepr[T <: HList, R <: HList]
//    (implicit merger: Merger.Aux[T, R, T]): UpdateRepr[T, R] =
//      new UpdateRepr[T, R] {
//        def apply(t: T, r: R): T = merger(t, r)
//      }
//
//    implicit def cnilUpdateRepr[R <: HList]: UpdateRepr[CNil, R] =
//      new UpdateRepr[CNil, R] {
//        def apply(t: CNil, r: R): CNil = t
//      }
//
//    implicit def cconsUpdateRepr[H, T <: Coproduct, R <: HList]
//    (implicit
//     uh: Lazy[UpdateRepr[H, R]],
//     ut: Lazy[UpdateRepr[T, R]]
//    ): UpdateRepr[H :+: T, R] =
//      new UpdateRepr[H :+: T, R] {
//        def apply(t: H :+: T, r: R): H :+: T = t match {
//          case Inl(h) => Inl(uh.value(h, r))
//          case Inr(t) => Inr(ut.value(t, r))
//        }
//      }
//
//    implicit def genProdUpdateRepr[T, R <: HList, Repr <: HList]
//    (implicit
//     prod: HasProductGeneric[T],
//     gen: LabelledGeneric.Aux[T, Repr],
//     update: Lazy[UpdateRepr[Repr, R]]
//    ): UpdateRepr[T, R] =
//      new UpdateRepr[T, R] {
//        def apply(t: T, r: R): T = gen.from(update.value(gen.to(t), r))
//      }
//
//    implicit def genCoprodUpdateRepr[T, R <: HList, Repr <: Coproduct]
//    (implicit
//     coprod: HasCoproductGeneric[T],
//     gen: Generic.Aux[T, Repr],
//     update: Lazy[UpdateRepr[Repr, R]]
//    ): UpdateRepr[T, R] =
//      new UpdateRepr[T, R] {
//        def apply(t: T, r: R): T = gen.from(update.value(gen.to(t), r))
//      }
//  }
//
//}
