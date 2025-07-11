
# Diccionarios iniciales
productos = {
    'PF100': ['Croquetas Adulto', 'perro', 'DogPlus', 'carne', 10],
    'PF101': ['Croquetas Cachorro', 'perro', 'CanPro', 'pollo', 5],
    'PF200': ['Galletas Felinas', 'gato', 'CatLovers', 'salmon', 0.5],
    'PF201': ['Croquetas Adulto', 'gato', 'GatoPlus', 'atun', 2],
    'PF300': ['Comida humeda', 'perro', 'DogPlus', 'cordero', 0.3],
    'PF301': ['Snacks', 'gato', 'CatLovers', 'pollo', 0.2],
};

inventario = {
    'PF100': [15990, 12],
    'PF101': [8990, 25],
    'PF200': [4990, 8],
    'PF201': [7990, 3],
    'PF300': [2290, 0],
    'PF301': [3490, 7],
};

# Funcion para stock por tipo de mascota
def stock_tipo(tipo):
    total = 0;
    for codigo, datos in productos.items():
        if(datos[1].lower() == tipo.lower()):
            total += inventario[codigo][1];
    print(f"El stock total para '{tipo}' es: {total}");

# Funcion para busqueda por peso
def buscar_por_peso(peso_min, peso_max):
    resultados = [];
    for codigo, datos in productos.items():
        peso = datos[4];
        if(peso >= peso_min and peso <= peso_max) and (inventario[codigo][1] > 0):
            resultados.append(codigo + '--' + datos[2]);
    if resultados:
        resultados.sort();
        print("Productos encontrados:", resultados);
    else:
        print("No hay productos en ese rango de peso.");

# Funcion para actualizar stock
def actualizar_stock(codigo, nuevo_stock):
    if(codigo in inventario):
        inventario[codigo][1] = nuevo_stock;
        return True;
    return False;

# Programa principal
def main():
    while True:
        print("\n*** MENU PRINCIPAL ***");
        print("1. Stock por tipo de mascota");
        print("2. Busqueda por rango de peso (kg)");
        print("3. Actualizar stock de producto");
        print("4. Salir");
        opc = int(input("Ingrese opcion: "));

        if(opc == 1):
            tipo = input("Ingrese tipo de mascota (perro/gato): ");
            stock_tipo(tipo);
        elif(opc == 2):
            try:
                peso_min = float(input("Ingrese peso minimo (kg): "));
                peso_max = float(input("Ingrese peso maximo (kg): "));
                buscar_por_peso(peso_min, peso_max);
            except ValueError:
                print("Debe ingresar valores numericos validos!!");
        elif(opc == 3):
            while True:
                codigo = input("Ingrese codigo de producto: ");
                try:
                    nuevo_stock = int(input("Ingrese nuevo stock: "));
                    if actualizar_stock(codigo, nuevo_stock):
                        print("Stock actualizado!");
                    else:
                        print("El codigo no existe!");
                except ValueError:
                    print("Debe ingresar un numero entero para el stock.");

                repetir = input("Desea actualizar otro producto (s/n)?: ").lower();
                if(repetir != 's'):
                    break;
        elif(opc == 4):
            print("Programa finalizado.");
            break;
        else:
            print("Debe seleccionar una opcion valida!!");

# Ejecutar programa
if __name__ == "__main__":
    main();
