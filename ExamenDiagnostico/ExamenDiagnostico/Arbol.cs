using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamenDiagnostico
{
    public class Arbol
    {
        public Nodo raiz;

        public Arbol()
        {
            raiz = null;
        }

        public void Insertar (char letra)
        {
            raiz = InsertarNodo (raiz,letra);
        }

        public Nodo InsertarNodo(Nodo nodo, char letra)
        {
            if(nodo == null)
            {
                nodo = new Nodo(letra);
                return nodo;
            }

            if(letra < nodo.Letra)
            {
                nodo.Nodoizq = InsertarNodo(nodo.Nodoizq,letra);
            }
            else
            {
                nodo.Nododer = InsertarNodo(nodo.Nododer,letra);
            }

            return nodo;
        }

        public bool Busqueda(char letra)
        {
            return BusquedaNodo(raiz,letra);
        }

        public bool BusquedaNodo(Nodo nodo, char letra)
        {
            if (nodo == null)
            {
                return false;
            }

            if(nodo.Letra == letra)
            {
                return true;
            }

            if (letra < nodo.Letra)
            {
                return BusquedaNodo(nodo.Nodoizq,letra);
            }
            else
            {
                return BusquedaNodo(nodo.Nododer,letra);
            }
        }

        public void RecorridoInOrder()
        {
            InOrder(raiz);
        }

        private void InOrder(Nodo nodo)
        {
            if (nodo != null)
            {
                InOrder(nodo.Nodoizq);
                Console.Write(nodo.Letra + " ");
                InOrder(nodo.Nododer);
            }
        }
    }
}
