//
//  ContentView.swift
//  iOS
//
//  Created by Ray Britton on 07/01/2022.
//

import SwiftUI

struct ContentView: View {
    @State private var num1: String = "0"
    @State private var num2: String = "0"
    @State private var result: String = "0"

    
    var body: some View {
        VStack {
        Text("Add two numbers")
            .padding()
        HStack {
            TextField("Number", text: $num1)
                .keyboardType(.numberPad)
                .onChange(of: num1){result = String(add(Int32($0) ?? 0, Int32(num2) ?? 0))}
            Text("+")
            TextField("Number", text: $num2)
                .keyboardType(.numberPad)
                .onChange(of: num2){result = String(add(Int32(num1) ?? 0, Int32($0) ?? 0))}
            Text("=")
            Text(result)
        }
    }
}
                 }

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
