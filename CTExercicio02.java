public class Cliente {
    private String nome;
    private String cpf;
    
    public Cliente(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

public abstract class Conta {
    private int numero;
    private Cliente titular;
    protected double saldo;
    
    public Conta(int numero, Cliente titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        saldo = 0;
    }
    
    public Conta(int numero, String nomeTitular, String cpfTitular) {
        this.numero = numero;
        this.titular = new Cliente(nomeTitular, cpfTitular);
        saldo = 0;
    }
    
    public Cliente getTitular() {
        return titular;
    }
    
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    
    public abstract boolean sacar(double valor);
}

public class ContaEspecial extends Conta {
    private double limite;
    
    public ContaEspecial(int numero, Cliente titular, double limite) {
        super(numero, titular, 0);
        this.limite = limite;
    }
    
    public ContaEspecial(int numero, Cliente titular) {
        super(numero, titular, 0);
        this.limite = 0;
    }
    
    public ContaEspecial(int numero, String nomeTitular, String cpfTitular, double limite) {
        super(numero, nomeTitular, cpfTitular);
        this.limite = limite;
    }
    
    @Override
    public boolean sacar(double valor) {
        if(valor <= this.limite + this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular, 0);
    }
    
    public ContaPoupanca(int numero, String nomeTitular, String cpfTitular) {
        super(numero, nomeTitular, cpfTitular);
    }
    
    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}
