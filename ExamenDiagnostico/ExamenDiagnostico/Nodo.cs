using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamenDiagnostico
{
    public class Nodo
    {
        public Nodo Nodoizq;
        public Nodo Nododer;
        public char Letra;

        public Nodo( char letra)
        {
            this.Nodoizq = null;
            this.Nododer = null;
            this.Letra = letra;
        }
    }
}
