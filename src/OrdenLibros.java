import java.util.ArrayList;
import java.util.Collections;

public class OrdenLibros {
	private ArrayList<Libros> libros = new ArrayList<Libros>();
	private ArrayList<Libros> Precios = new ArrayList<Libros>();
	
	public void almacenar(Libros libro) {
		libros.add(libro);
	}
	
	public Libros getLibrobyIsbn(String isbn) {
		for(Libros l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}

	public ArrayList<Libros> getLibros() {
		return libros;
	}	
	
	public void ventaLibros(String isbn, int cantidad) {
		if(getLibrobyIsbn(isbn) == null) {
			System.out.println("ISBN incorrecto");}
		else
			if(getLibrobyIsbn(isbn).getCantidad() >= cantidad) {
				System.out.println("=======Venta=======");
				System.out.print("ISBN: "+ isbn);
				System.out.print("Titulo: "+ getLibrobyIsbn(isbn).getTitulo());
				System.out.print("Precio: "+ getLibrobyIsbn(isbn).getPrecio());
				System.out.print("Cantidad: "+ cantidad);
				System.out.print("Total a pagar: $"+
				getLibrobyIsbn(isbn).getPrecio()*cantidad+" ");
				getLibrobyIsbn(isbn).setCantidad((getLibrobyIsbn(isbn).getCantidad() - cantidad));
				if(getLibrobyIsbn(isbn).getCantidad() > cantidad) {
					System.out.println("Libro agotado");
					libros.remove(libros.indexOf(getLibrobyIsbn(isbn)));
					}
			} else {
				System.out.println("No se posee dicha cantidad de libros en stock");
				System.out.println("Cantidad de libros en stock: "+getLibrobyIsbn(isbn).getCantidad());
			}
	}
	
	public void OPrecios() {
		Precios = new ArrayList<Libros>();
		for(int i=0; i<libros.size(); i++) {
			Precios.add(libros.get(i));
		}
		Collections.sort(Precios, new Precio());
		
	}
	
	
