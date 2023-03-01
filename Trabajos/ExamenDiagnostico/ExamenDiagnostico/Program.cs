using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamenDiagnostico
{
    class Program
    {
        static void Main(string[] args)
        {

            int nodosTotales = 0, respuesta = 0;
            Arbol ArbolCompleto = new Arbol();

            while (nodosTotales <= 0)
            {
                Console.WriteLine("Cuantos nodos quiere?");
                nodosTotales = int.Parse(Console.ReadLine());

                if (nodosTotales==0)
	            {
                    Console.WriteLine("Tiene que ser un numero mayor a 0");
	            }
            }

            char nodo;
            Console.WriteLine("\nEscribe las letras del nodo:");
            for (int i = 0; i < nodosTotales; i++)
            {
                nodo = Convert.ToChar(Console.ReadLine());
                ArbolCompleto.Insertar(nodo);
            }
            Console.WriteLine("Recorrido in Order: ");
            ArbolCompleto.RecorridoInOrder();

            while(respuesta != 1 && respuesta != 2)
            {
                Console.WriteLine("\nDesea buscar algun nodo? Si es asi presione 1, si no presione 2");
                respuesta = int.Parse(Console.ReadLine());
            }
            

            if (respuesta == 1)
	        {
                Console.WriteLine("Que nodo desea buscar? (Escriba la letra a buscar): ");
                char busquedaNodo = Convert.ToChar(Console.ReadLine());

                Console.WriteLine("La letra " + busquedaNodo+" se encontro? : " + ArbolCompleto.Busqueda(busquedaNodo));
	        }
            else
            {
                Console.WriteLine("\nPresione Cualquier tecla");
                Console.ReadKey();
            }

            
        }
    }
}
