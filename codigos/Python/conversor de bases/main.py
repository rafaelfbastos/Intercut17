from tkinter import *
from tkinter import ttk
from tkinter import messagebox
from conversor_base import *


def calcular(numero,base_atual,base_desejada):
    if(validar_base_numero(numero=numero,base=base_atual)):
        resultado = converter_base(numero=numero,base_atual=base_atual,base_desejada=base_desejada)
        resposta.set(resultado)
    
    else:
       messagebox.showerror(title="Erro", message=f'O número {numero} não está na base {base_atual}')

janela = Tk()
janela.title("Conversor de Base")

base_atual = StringVar()
base_desejada = StringVar()
resposta = StringVar()

base_atual.set("2")
base_desejada.set("2")

janela.geometry("400x300")
frame = Frame(janela, padx=10, pady=10)
frame.grid()


label1 = Label(frame, text="Digite o número:").grid(row=0,column=0,padx=10,pady=10)
numero = Entry(frame,width=25)
numero.grid(row=0, column=1,padx=10, pady=10)


label2 = Label(frame, text="Informe a base do número").grid(row=1,column=0,padx=10,pady=10)
base_atual_entry = ttk.Combobox(frame, values=lista_bases,textvariable=base_atual).grid(row=1, column=1,pady=10)
label3 = Label(frame, text="Informe a base do número").grid(row=2,column=0,padx=10,pady=10)
base_desejada_entry = ttk.Combobox(frame, values=lista_bases,textvariable=base_desejada).grid(row=2, column=1,pady=10)

button = Button(frame,text="Calcular",
command=lambda: calcular(numero=numero.get(),base_atual=base_atual.get(),base_desejada=base_desejada.get())
).grid(row=3,column=1)



label3 = Label(frame, textvariable=resposta, background="black", font=("Arial",10,"bold"),width=25, height=3, foreground="white").grid(row=4,column=0,columnspan=2,pady=(20,5))


janela.mainloop()