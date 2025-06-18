package com.sample.core.enums;


public enum RolEnum {
    PRESIDENTE("presidente"),
    VICEPRESIDENTE("vicepresidente"),
    GOBERNADOR("gobernador");

	private String tipo;
	
	 RolEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static RolEnum obtenerRol(String rol) {
	    if (rol == null) {
	        throw new IllegalArgumentException("El rol no puede ser nulo");
	    }
	    // buscar el enum cuyo 'tipo' coincide (ignorando mayúsculas)
	    for (RolEnum r : RolEnum.values()) {
	        if (r.getTipo().equalsIgnoreCase(rol)) {
	            return r;
	        }
	    }
	    throw new IllegalArgumentException("Rol no válido: " + rol);
	}
	
}


