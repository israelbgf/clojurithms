(ns clojurithms.overview)

; data structures
; simbolo-qualquer
1
1.0
1/2
[1 2 3]
'(1 2 3)
#{1 2 3}
:shu
{:nome "Juca", 10 30, [1 2] '(999)}

({:nome "Juca", 10 30, [1 2] '(999)} :nome)

(+ 1 1)
(- 1 1/2)


(def criador-do-clojure "Rich Hickey")
(str "Hello " criador-do-clojure)


(if (= 0.5 (float 1/2)) (println "Eita nois.") (println "Nao pode se."))


((fn [funcao-a funcao-b [primeiro segundo & resto]]
   (println (funcao-a primeiro segundo))
   (println (apply funcao-b resto))) + - [2 2 5 5])


(defn contar
  ([até]
   (contar 0 até))
  ([a-partir-de até]
   (loop [contador a-partir-de]
     (println contador)
     (if (= contador até)
       (do
         (future
           (Thread/sleep 5000)
           (println "Sério. Volta python."))
         (println "nao aquento mais esses parênteses."))
       (recur (inc contador))))))

(contar 5)


(let [o-futuro-me-aguarda (future
                            (Thread/sleep 5000)
                            (println "Fiz altos processamento.")
                            (java.util.UUID/randomUUID))]
  (println (str "Vou esperar até vir " (deref o-futuro-me-aguarda)))
  (println (str "Fique cacheado até: " @o-futuro-me-aguarda)))


(try
  (/ 1 0)
  (catch Exception e
    (str "caught exception: " (.getMessage e))))

; Apertem os cintos.
(defmacro matematica-normal
  [[a funcao b]]
  (list funcao a b))

(matematica-normal (2 - 3))
